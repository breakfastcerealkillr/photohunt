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
      <h:dataTable value="#{approvalBean.approvedPictures}" var="picture" id="approvedTable">
        <f:facet name="header">
          <h:outputText value="The following pictures will be available for public viewing." />
        </f:facet>
        <h:column>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
        </h:column>
      </h:dataTable>
      <h:selectBooleanCheckbox value="#{approvalBean.removeDenied}" />
      <h:outputText value="Delete unapproved pictures permanently." /><br>
      <h:outputText value="Are you sure you want to continue?" /><br>
      <h:form>
        <h:commandButton action="#{approvalBean.approvePictures}" value="Continue" />
        <h:commandButton action="return" value="Go back" />
      </h:form>
    </div>
    </f:view>
  </body>
</html>