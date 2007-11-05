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
      </div>

      <div class="content">
        <h3>Picture Approval</h3>

        <rich:simpleTogglePanel id="instructions" switchType="AJAX" 
          label="Instructions for approving pictures.">
          <h:outputText value="To approve pictures, drag a picture into the approved 
            pictures section.  To submit the pictures, click on the approve button."/>
          <f:verbatim><br></f:verbatim>
          <h:outputText value="To delete a picture, move it into the trash on the right.  
            Click on the empty button to empty the list of pictures." />
        </rich:simpleTogglePanel>
        
        <rich:spacer height="10"/>
        
        <rich:dragIndicator id="indicator"/>
        <h:form>
        <div class="deleted">
          <rich:simpleTogglePanel id="deleted" switchType="AJAX" label="Deleted Pictures">
		    <rich:dropSupport acceptedTypes="pic" reRender="approved, pending, deleted" dropValue="delete"
              dropListener="#{eventBean.processDrop}" id="deleteDrop"/>
           <rich:dataGrid value="#{approvalBean.deletedPictures}" var="picture" id="deletedGrid"
              columns="2" rendered="#{!empty approvalBean.deletedPictures}">
              <f:facet name="footer">
                <a4j:commandButton reRender="deleted" action="#{approvalBean.delete}" value="Delete" />
              </f:facet>
              <a4j:outputPanel>
                <rich:dragSupport dragIndicator=":indicator" dragType="pic" dragValue="#{picture}"/>
                <h:graphicImage url="#{picture.path}" height="75" width="100"/>
                <h:outputText value="#{picture.tagLabel}" style="display:block"/>
              </a4j:outputPanel>
            </rich:dataGrid>
		  </rich:simpleTogglePanel>
        </div>
        
        <div class="pending-approved">
        <rich:simpleTogglePanel id="pending" switchType="AJAX" label="Pending Pictures">
          <rich:dropSupport acceptedTypes="pic" reRender="approved, pending, deleted" dropValue="pending"
            dropListener="#{eventBean.processDrop}" id="pendingDrop">
          </rich:dropSupport>
          <rich:dataGrid value="#{approvalBean.pendingPictures}" var="picture" id="pendingGrid"
            columns="6" elements="24" rendered="#{!empty approvalBean.pendingPictures}">
            <a4j:outputPanel>
              <rich:dragSupport dragIndicator=":indicator" dragType="pic" dragValue="#{picture}"/>
              <h:graphicImage url="#{picture.path}" height="75" width="100"/>
              <h:outputText value="#{picture.tagLabel}" style="display:block"/>
            </a4j:outputPanel>
            <f:facet name="footer">
              <rich:datascroller for="pendingGrid" reRender="pending"/>
            </f:facet>
          </rich:dataGrid>
        </rich:simpleTogglePanel>
        
        <rich:spacer height="10" />
        
        <rich:simpleTogglePanel id="approved" switchType="AJAX" label="Approved Pictures">
          <rich:dropSupport acceptedTypes="pic" reRender="approved, pending, deleted" dropValue="approve"
            dropListener="#{eventBean.processDrop}" id="approveDrop">
          </rich:dropSupport>
          <rich:dataGrid value="#{approvalBean.approvedPictures}" var="picture" id="approvedGrid"
            columns="6" rendered="#{!empty approvalBean.approvedPictures}">
            <f:facet name="footer">
              <a4j:commandButton reRender="approved" action="#{approvalBean.approve}" value="Approve" />
            </f:facet>
            <a4j:outputPanel>
              <rich:dragSupport dragIndicator=":indicator" dragType="pic" dragValue="#{picture}"/>
              <h:graphicImage url="#{picture.path}" height="75" width="100"/>
              <h:outputText value="#{picture.tagLabel}" style="display:block"/>
            </a4j:outputPanel>
          </rich:dataGrid>
        </rich:simpleTogglePanel>
        </div>
        </h:form>
        
      </div>
    </f:view>
  </body>
</html>