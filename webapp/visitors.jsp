<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Visitors</title>
    <style>
	  @import "stylesheet.css";
    </style>
  </head>
  <body>
    <f:view>
      <%@ include file="Header.jsp" %>
      <div class="sidebar">
        <%@ include file="visitors-navbar.jsp" %>
        <h:form id="tagbrowser">
          <h:outputText value="Select a tag."/>
          <p><h:selectOneMenu id="selectTag" value="#{pictureBean.tag}" required="true">
            <f:selectItems value="#{pictureBean.tagList}" />
		  </h:selectOneMenu></p>
          <p><h:commandButton action="#{pictureBean.update}" value="Go" />
		</h:form>
	  </div>
	  <div class="content">
	  <h:outputText value="#{pictureBean.status}" style="#{pictureBean.statusStyle}" />
      <h:dataTable value="#{pictureBean.pictures}" var="picture" id="pictureList">
        <h:column>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
        </h:column>
      </h:dataTable>
      </div>
    </f:view>
  </body>
</html>