<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Staff Login</title>
    <style>
      @import "stylesheet.css";
    </style>
  </head>
  <body>
    <f:view>
      <%@ include file="Header.jsp" %>
      <h:form>
	    <h3>Please enter your name and password.</h3>
	    <h:outputText value="#{loginBean.error}" style="color: darkred"/>
	    <p><h:outputText value="Name: " />
	    <h:inputText value="#{loginBean.name}" /></p>
		<p><h:outputText value="Password: "/>
		<h:inputSecret value="#{loginBean.password}" /></p>
	    <p><h:commandButton value="Login" action="#{loginBean.login}" /></p>
	  </h:form>
	</f:view>
  </body>
</html>