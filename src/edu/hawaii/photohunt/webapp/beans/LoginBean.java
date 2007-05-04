package edu.hawaii.photohunt.webapp.beans;

/**
 * The LoginBean backs the login page for Photo Hunt. It currently contains hard-coded values for
 * username and password, but that will change in a future revision.
 * 
 * @author George Lee
 * 
 */
public class LoginBean {
  /** The valid username. */
  private static final String validName = "photohunt";
  
  /** The valid password. */
  private static final String validPassword = "uhmics414";
  
  /** The username retrieved from the user. */
  private String name;
  
  /** The password retrieved from the user. */
  private String password;
  
  /** The login status of the user. */
  private boolean loggedIn = false;
  
  /** Default constructor. */
  public LoginBean() {
    //Needs to be left empty.
  }
  
  /**
   * Get the username.
   * 
   * @return The currently inputted username.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Set the username to the inputted value.
   * 
   * @param name The value to be inserted into the username.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Get the password.
   * 
   * @return The currently inputted password.
   */
  public String getPassword() {
    return this.password;
  }
  
  /**
   * Set the password to the inputted value.
   * 
   * @param password the value to be inserted as the password.
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * Get the login status of the LoginBean.
   * 
   * @return True if the user is still logged in, false otherwise.
   */
  public boolean getLoggedIn() {
    return this.loggedIn;
  }
  
  /**
   * Log in using the provided username and password.
   * 
   * @return Returns "continue" if the username and password is correct. Returns null otherwise to
   *         return to the current page.
   */
  public String login() {
    if (this.name.equals(validName) && this.password.equals(validPassword)) {
      this.loggedIn = true;
      return "continue";
    }
    
    return null;
  }
  
  /**
   * Log out the user.
   * 
   * @return Returns logout to return to the front page.
   */
  public String logout() {
    this.loggedIn = false;
    return "logout";
  }
}
