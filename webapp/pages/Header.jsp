<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <style type="text/css">
  </style>
  <head>
    <title>Photo Hunt</title>
  </head>
  <body>
    <f:view>
    <font face="Arial">
    <h2>Photo Hunt</h2>

    <h:outputLink value="/pages/slideshow.jsp">
      <f:verbatim>Visitors</f:verbatim>
    </h:outputLink>
    
    <f:verbatim>&nbsp</f:verbatim>
    <h:outputLink value="/pages/login.jsp">
      <f:verbatim>Employees</f:verbatim>
    </h:outputLink>
    
    <hr>
    </f:view>