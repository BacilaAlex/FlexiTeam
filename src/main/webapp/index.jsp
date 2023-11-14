<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

    <t:pageTemplate pageTitle="FlexiTeam">
      <h1>hello!</h1>
      <button style="width: 150px" onclick="navigateToHome()">To home page</button>

    </t:pageTemplate>
<script>
  function navigateToHome() {
    window.location.href = '/FlexiTeam-1.0-SNAPSHOT/home.jsp';
  }
</script>