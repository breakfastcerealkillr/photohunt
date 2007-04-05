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
      <h:dataTable value="#{pictureBean.deletedPictures}" var="picture" id="deletedTable">
        <f:facet name="header">
          <h:outputText value="The following pictures will be permanently deleted." />
        </f:facet>
        <h:column>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
        </h:column>
      </h:dataTable>
      <h:outputText value="Are you sure you want to continue?" /><br>
      <h:form>
        <h:commandButton action="#{pictureBean.deletePictures}" value="Continue" />
        <h:commandButton action="return" value="Go back" />
      </h:form>
    </div>
    </f:view>
  </body>
</html>