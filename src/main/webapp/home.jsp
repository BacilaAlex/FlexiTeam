<%--
  Created by IntelliJ IDEA.
  User: winko
  Date: 12.11.2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Home">
  <div class="flex_justify_between">
  <div class="flex_row">
  <h1 class="font w13">FlexiTeam ®</h1>
    <div class="div1"></div>
  </div>

  <div class="flex div_cu_bulinuta ">
    <div class="circle">
    </div>
  <div class="div2">
  </div>
    </div>
  </div>
  <style>
    .div1{
      background-color: white;
      height: 85%;
      width: 100%;
      border-radius: 15px;
    }
    .flex_row{
      display: flex;
      flex-direction: column;
      height: 100%;
      margin-left: 30px;
    }
    .div2{
      background-color: white;
      height: 86%;
      width: 95%;
      min-width: 15%;
      border-radius: 15px;
      align-self: center;
      margin-top: 20px;
      margin-right: 30px;
    }
    .flex_justify_between{
      display: flex;
      flex-direction: row;
      /*flex-wrap: wrap;*/
      gap: 80px;
      height:100%;
    }
    .w13{
      width: 250px;
    }
    .circle{
      background-color: white;
      height: 60px;
      width: 60px;
      border-radius: 50px;
      margin-right: 4%;
    }
    .div_cu_bulinuta{
      width:100%;flex-direction: column; align-items: end;margin-top: 10px;
    }
  </style>
</t:pageTemplate>

