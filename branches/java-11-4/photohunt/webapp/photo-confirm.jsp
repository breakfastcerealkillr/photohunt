<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Approval</title>
    <style>
      @import "stylesheet.css";
    </style>
  </head>
  <body>
    <f:view>
    <%@ include file="Header.jsp" %>
    <div class="sidebar">
        <%@ include file="staff-navbar.jsp" %>
    </div>
    <div class="content">
      <h3>Photo Management - Deletion Confirmation</h3>
      <rich:dataGrid value="#{pictureBean.deletedPictures}" var="picture" id="deletedGrid"
        columns="4">
        <f:facet name="header">
          <h:outputText value="The following pictures will be permanently deleted." />
        </f:facet>
        <h:outputLink value="#{picture.path}">
          <h:graphicImage url="#{picture.path}" height="75" width="100"/>
        </h:outputLink>
      </rich:dataGrid>
      <rich:spacer height="10" />
      <h:outputText value="Are you sure you want to continue?" /><br>
      <h:form>
        <h:commandButton action="#{pictureBean.deletePictures}" value="Continue" />
        <h:commandButton action="return" value="Go back" />
      </h:form>
    </div>
    </f:view>
  </body>
</html>