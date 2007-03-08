<%@ include file="Header.jsp" %>

<f:view>
  <h:graphicImage url="#{approvalBean.currentPicture}"/>
  <h:form>
  <h:commandLink id="approve" action="#{approvalBean.approvePicture}">
    <h:outputText value="Approve"/>
  </h:commandLink>
  
  <h:commandLink id="deny" action="#{approvalBean.denyPicture}">
    <h:outputText value="Deny"/>
  </h:commandLink>
  </h:form>
</f:view>

<%@ include file="Footer.jsp" %>
