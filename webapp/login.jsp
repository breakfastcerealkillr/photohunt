<%@ include file="Header.jsp" %>

This is the login page.  It has not been implemented yet.
<p>
<f:view>
  <h:form id="to-approval">
    <h:commandLink id="approve" action="#{approvalBean.setCurrentPicture}">
      <h:outputText value="Continue to approval process."/>
    </h:commandLink>
  </h:form>
</f:view>

<%@ include file="Footer.jsp" %>