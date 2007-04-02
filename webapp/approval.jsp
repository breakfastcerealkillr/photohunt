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
      <f:view>
      <div class="sidebar">
        <%@ include file="staff-navbar.jsp" %>
        <h:form style="margin-top: 30px; padding: 5px; background-color: #FEF886">
          <h:outputText value="Select a tag."/>
          <p><h:selectOneMenu id="selectTag" value="#{approvalBean.tag}" required="true">
            <f:selectItems value="#{approvalBean.tagList}" />
		  </h:selectOneMenu></p>
		  <p><h:commandButton action="#{approvalBean.changeTag}" value="Go" />
		</h:form>
      </div>
    <div class="content">
     <h:outputText value="Current tag: #{approvalBean.tag}" />
     <h:form>
        <h:dataTable value="#{approvalBean.pendingPictures}" var="picture"
          rendered="#{!empty approvalBean.pendingPictures}" id="pictureList">
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
        
        <h:commandButton action="#{approvalBean.sortPictures}" value="Submit" 
         rendered="#{!empty approvalBean.pendingPictures}" />
      </h:form>
    </f:view>
    </div>

    </font>
  </body>
</html>