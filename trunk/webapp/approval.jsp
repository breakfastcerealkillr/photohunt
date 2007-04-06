<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<%@ taglib uri="http://richfaces.ajax4jsf.org/rich" prefix="rich" %>

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
     <h:outputText value="#{approvalBean.status}" />
     <h:form>
        <rich:dataTable id="pictureList" value="#{approvalBean.pendingPictures}" var="picture"
          cellpadding="10px" columnClasses="col" rows="5"
          rendered="#{!empty approvalBean.pendingPictures}">
          <f:facet name="header">
            <rich:columnGroup>
              <h:column>
                <h:outputText styleClass="headerText" value="Approve" />
              </h:column>
              <h:column>
                <h:outputText styleClass="headerText" value="Picture" />
              </h:column>
            </rich:columnGroup>
          </f:facet>
          
          <h:column>
            <h:selectBooleanCheckbox value="#{picture.approved}">
              <a4j:support event="onclick" />
            </h:selectBooleanCheckbox>
          </h:column>
          <h:column>
            <h:outputLink value="#{picture.path}">
              <h:graphicImage url="#{picture.path}" height="75" width="100"/>
            </h:outputLink>
          </h:column>
        </rich:dataTable>
        
        <rich:datascroller for="pictureList" rendered="#{!empty approvalBean.pendingPictures}"/>
        <rich:spacer height="20" />
        <h:commandButton action="#{approvalBean.sortPictures}" value="Submit" 
          rendered="#{!empty approvalBean.pendingPictures}"/>
      </h:form>
    </div>
    </f:view>
  </body>
</html>