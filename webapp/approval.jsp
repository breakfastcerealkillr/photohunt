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
        <h:form id="tagbrowser">
          <h:outputText value="Select a tag."/>
          <p><h:selectOneMenu id="selectTag" value="#{approvalBean.tag}" required="true">
            <f:selectItems value="#{approvalBean.tagList}" />
		  </h:selectOneMenu></p>
		  <p><h:commandButton action="#{approvalBean.changeTag}" value="Go" />
		</h:form>
      </div>
    <div class="content">
     <h3>Picture Approval</h3>
     <h:outputText value="Current tag: #{approvalBean.tag}" />
     <h:form>
        <h:dataTable value="#{approvalBean.pendingPictures}" var="picture"
          style="margin-top: 10px" cellpadding="10px"
          rendered="#{!empty approvalBean.pendingPictures}">
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
          <f:facet name="footer">
            <h:commandButton action="#{approvalBean.sortPictures}" value="Submit" />
          </f:facet>
        </h:dataTable>
      </h:form>
    </div>
    </f:view>
  </body>
</html>