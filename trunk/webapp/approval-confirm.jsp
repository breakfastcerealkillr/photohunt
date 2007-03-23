<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Approval</title>
  </head>
  <body>
    <font face="Arial">
      <%@ include file="Header.jsp" %>
      <div class="sidebars" style="float: left">
      <%@ include file="staff-navbar.jsp" %>
      <div class="tag-sidebar" style="margin-top: 10px">
        Tag Browser:
      </div>
    </div>
    <div class="content" style="padding: 10px; margin-top: 5px; margin-left: 145px">
      <div class="approved" >
      <f:view>
        <h:dataTable value="#{approvalBean.approvedPictures}" var="picture"
          style="background-color: #bedfc4; margin-left: 10px; margin-right: auto; border: 1px">
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
    </div>

    </font>
  </body>
</html>