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
          <div class="sidebar" style="float:left; margin-top: 10px" />
          <h:form>
            <h:selectOneMenu id="selectTag" value="#{pictureBean.tag}" required="true">
              <f:selectItem itemValue="pictures/approved/sample-pictures/" itemLabel="Sample Pictures" />
		    </h:selectOneMenu>
		    <p><h:commandButton action="#{pictureBean.update}" value="Go" />
		  </h:form>
		  </div>
	  <div class="content" style="padding: 10px; margin-top: 5px; margin-left: 145px">
      <h:dataTable value="#{pictureBean.approvedPictures}" var="picture">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Current Tag: #{pictureBean.tag}" style="text-decoration: none"/>
          </f:facet>
          <h:outputLink value="#{picture.path}">
            <h:graphicImage url="#{picture.path}" height="180" width="240"/>
          </h:outputLink>
        </h:column>
      </h:dataTable>
      </div>
    </f:view>
    </font>
  </body>
</html>