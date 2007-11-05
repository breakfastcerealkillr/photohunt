<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich" %>

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
	  <rich:panel>
	    <f:facet name="header">
	      <h:outputText value="#{pictureBean.status}" style="#{pictureBean.statusStyle}" />
	    </f:facet>
	    <h:form>
          <rich:dataGrid value="#{pictureBean.pictures}" var="picture" id="pictureList"
            columns="6" rendered="#{!empty pictureBean.pictures}">
          
            <h:outputLink value="#{picture.path}">
              <h:graphicImage url="#{picture.path}" height="75" width="100"/>
            </h:outputLink>
            <f:facet name="footer">
              <rich:datascroller for="pictureList"/>
            </f:facet>
          </rich:dataGrid>
        </h:form>
      </rich:panel>
      </div>
    </f:view>
  </body>
</html>