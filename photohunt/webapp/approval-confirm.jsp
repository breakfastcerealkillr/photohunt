<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>

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
      <h3>Picture Approval - Confirmation</h3>
      <rich:dataGrid value="#{approvalBean.approvedPictures}" var="picture" id="approvedGrid"
        columns="4">
        <f:facet name="header">
          <h:outputText value="The following pictures will be available for public viewing." />
        </f:facet>
        <h:outputLink value="#{picture.path}">
          <h:graphicImage url="#{picture.path}" height="75" width="100"/>
        </h:outputLink>
      </rich:dataGrid>
      <rich:spacer height="10" />
      <h:selectBooleanCheckbox value="#{approvalBean.removeDenied}">
        <a4j:support event="onclick" reRender="warning" />
      </h:selectBooleanCheckbox>
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