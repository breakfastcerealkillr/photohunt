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
    <f:view>
     <h:form>
        <h:dataTable value="#{approvalBean.pendingPictures}" var="picture">
          <h:column>
            <f:facet name="header">
              <h:outputText value="Approve" />
            </f:facet>
            <h:selectBooleanCheckbox value="#{picture.approved}" />
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Picture" />
            </f:facet>
            <h:outputLink value="#{picture.path}">
              <h:graphicImage url="#{picture.path}" height="180" width="240"/>
            </h:outputLink>
          </h:column>
        </h:dataTable>
        
        <h:commandButton action="#{approvalBean.sortPictures}" value="Submit" />
      </h:form>
    </f:view>
    </div>

    </font>
  </body>
</html>