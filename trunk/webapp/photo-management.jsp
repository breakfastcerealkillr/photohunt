<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Photo Management</title>
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
          <p><h:selectOneMenu id="selectTag" value="#{pictureBean.tag}" required="true">
            <f:selectItems value="#{pictureBean.tagList}" />
		  </h:selectOneMenu></p>
		  <p><h:commandButton action="#{pictureBean.update}" value="Go" />
		</h:form>
      </div>
    <div class="content">
     <h3>Photo Management</h3>
     <h:outputText value="Current tag: #{pictureBean.tag}" />
     <h:form>
        <h:dataTable value="#{pictureBean.pictures}" var="picture"
          style="margin-top: 10px" cellpadding="10px"
          rendered="#{!empty pictureBean.pictures}">
          <h:column>
            <f:facet name="header">
              <h:outputText value="Delete" />
            </f:facet>
            <h:selectBooleanCheckbox value="#{picture.delete}" />
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
            <h:commandButton action="#{pictureBean.sortPictures}" value="Submit" />
          </f:facet>
        </h:dataTable>
      </h:form>
    </div>
    </f:view>
  </body>
</html>