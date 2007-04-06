<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich" %>

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
     <h:outputText value="#{pictureBean.status}" style="#{pictureBean.statusStyle}"/>
     <h:form>
        <rich:dataTable id="pictureList" value="#{pictureBean.pictures}" var="picture"
          cellpadding="10px" columnClasses="col" rows="5"
          rendered="#{!empty pictureBean.pictures}">
          <f:facet name="header">
            <rich:columnGroup>
              <h:column>
                <h:outputText styleClass="headerText" value="Delete" />
              </h:column>
              <h:column>
                <h:outputText styleClass="headerText" value="Picture" />
              </h:column>
              <h:column>
                <h:outputText styleClass="headerText" value="Submitted By" />
              </h:column>
            </rich:columnGroup>
          </f:facet>
          
          <h:column>
            <h:selectBooleanCheckbox value="#{picture.delete}">
              <a4j:support event="onclick" />
            </h:selectBooleanCheckbox>
          </h:column>
          <h:column>
            <h:outputLink value="#{picture.path}">
              <h:graphicImage url="#{picture.path}" height="75" width="100"/>
            </h:outputLink>
          </h:column>
        </rich:dataTable>
        
        <rich:datascroller for="pictureList" rendered="#{!empty pictureBean.pictures}"/>
        <rich:spacer height="10" />
        <h:commandButton action="#{pictureBean.sortPictures}" value="Submit" 
          rendered="#{!empty pictureBean.pictures}"/>
      </h:form>
    </div>
    </f:view>
  </body>
</html>