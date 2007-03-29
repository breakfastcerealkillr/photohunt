<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <head>
    <title>Photo Hunt - Visitors</title>
  </head>
  <body>
    <font face="Arial">
      <%@ include file="Header.jsp" %>
        <f:view>
          <h:selectOneMenu id="selectTag" value="#{pictureBean.currentTag}" style="float: left; margin-top: 10px">
            <f:selectItems value="#{pictureBean.tagList}" />
		  </h:selectOneMenu>
      <h:outputText value="Currently Browsing: #{pictureBean.currentTag}" />
      <h:dataTable value="#{pictureBean.approvedPictures}" var="picture" style="padding: 10px; margin-top: 5px; margin-left: 145px">
        <h:column>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
        </h:column>
      </h:dataTable>
    </f:view>
    </font>
  </body>
</html>