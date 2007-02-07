<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <style type="text/css">
    #nav-bar{position: fixed; background-color: aqua}
    a{text-decoration: none; font-weight: bold; color: blue}
  </style>
  <head>
    <title>Photo Hunt</title>
  </head>
  <body>
    <font face="Arial">
    <h2>Photo Hunt</h2>
    <hr>
    <div id="nav-bar">
        <h:commandLink id="visitor" action="slideshow">
          <h:outputText value="Visitors" />
        </h:commandLink>
        <h:commandLink id="employee" action="login">
          <h:outputText value="Employee Login" />
        </h:commandLink>
    </div>