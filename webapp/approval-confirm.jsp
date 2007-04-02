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
    <font face="Arial">
      <%@ include file="Header.jsp" %>
      <div class="sidebar">
        <%@ include file="staff-navbar.jsp" %>
      </div>
    <div class="approved">
      <f:view>
        <h:dataTable value="#{approvalBean.approvedPictures}" var="picture">
          <f:facet name="header">
            <h:outputText value="The following pictures will be available for public viewing." />
          </f:facet>
          <h:column>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
          </h:column>
        </h:dataTable>
        <h:outputText value="Are you sure you want to continue?" />
        <f:verbatim><br /></f:verbatim>
        <h:form>
          <h:commandButton action="#{approvalBean.approvePictures}" value="Continue" />
          <h:commandButton action="return" value="Go back" />
        </h:form>
      </f:view>
    </div>

    </font>
  </body>
</html>