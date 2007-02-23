<%@ include file="Header.jsp" %>

<f:view>
  <h:graphicImage url="#{pictureBean.currentPicture}"/>
  <h:form>
  <h:commandLink action="#{pictureBean.setCurrentPicture}">
    <h:outputText value="Next"/>
  </h:commandLink>
  </h:form>
</f:view>

<%@ include file="Footer.jsp" %>