package edu.hawaii.photohunt.webapp.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import edu.hawaii.photohunt.webapp.beans.LoginBean;

/**
 * The SecurityFilter class will check if the user accesses a protected resource. If they do, the
 * filter will redirect to login page if they're not already logged in.
 * 
 * Borrows implemented code by Derek Shen (<a href="derek_shen@hotmail.com">Email</a>).
 * 
 * @author George Lee
 * 
 */
public class SecurityFilter implements Filter {

  /** URI of the login page. */
  public static final String LOGIN_PAGE_URI = "login.jsf";

  /** List of restricted pages. */
  private List<String> restrictedPages = new ArrayList<String>();

  /**
   * Eliminates the Filter. Is not implemented.
   */
  public void destroy() {
    // Required by interface, but not implemented.
  }

  /**
   * Action performed by the Filter when it is called. The filter will check if the URI is
   * restricted and if the user is authenticated. If they are not authenticated, the filter forwards
   * to the login page.
   * 
   * @param req The ServletRequest called before the filter.
   * @param res The response of the filter according to the request.
   * @param chain The chain from the request to the response.
   * @exception IOException Should not be thrown. Required by interface.
   * @exception ServletException Should not be thrown. Required by interface.
   */
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    String contextPath = ((HttpServletRequest) req).getContextPath();
    String requestUri = ((HttpServletRequest) req).getRequestURI();

    if (this.contains(requestUri, contextPath) && !this.authorize((HttpServletRequest) req)) {
      ((HttpServletRequest) req).getRequestDispatcher(LOGIN_PAGE_URI).forward(req, res);
    }
    else {
      chain.doFilter(req, res);
    }

  }

  /**
   * Initialize the SecurityFilter by adding the restricted pages to the list.
   * 
   * @param config Unused parameter required by interface.
   * @exception ServletException should not be thrown, but is required by the interface.
   */
  public void init(FilterConfig config) throws ServletException {
    this.restrictedPages = new ArrayList<String>();
    this.restrictedPages.add("/staff.jsf");
    this.restrictedPages.add("/approval.jsf");
  }

  /**
   * Check to see if the URI is in the list of restricted pages.
   * 
   * @param value The page being accessed.
   * @param contextPath The actual URI path to this application (i.e. localhost:8080/photohunt/).
   * @return True if the page is protected, false otherwise.
   */
  public boolean contains(String value, String contextPath) {
    for (String page : this.restrictedPages) {
      if (value.equalsIgnoreCase(contextPath + page)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if the user is authenticated or not.
   * 
   * @param req The request sent by the user.
   * @return Returns true if the user is logged in. Returns false otherwise.
   */
  private boolean authorize(HttpServletRequest req) {
    LoginBean user = (LoginBean) req.getSession().getAttribute("loginBean");

    if (user != null && user.getLoggedIn()) {
      // user logged in
      return true;
    }
    
    return false;
  }
}
