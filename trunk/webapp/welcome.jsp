<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt</title>
    <style>
      @import "stylesheet.css";
    </style>
  </head>
  <body>
    <font face="Arial">
      <%@ include file="Header.jsp" %>
      Welcome to Photo Hunt!<br/>
      <ui>
        <li>If you are a visitor, please click on the visitor link to view pictures.</li>
        <li>If you are an employee or administrator, please click on the employee link to log in.</li>
      </ui>
      <%@ include file="Footer.jsp" %>
    </font>
  </body>
</html>