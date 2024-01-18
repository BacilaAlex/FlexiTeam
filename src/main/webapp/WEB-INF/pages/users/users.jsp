<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:pageTemplate pageTitle="Users">
  <div class="flex_justify_between">
    <div class="flex_row">
      <h1 class="font w13">FlexiTeam ®</h1>
      <div class="div1">
        <ul class="list-group">
          <li class="list-group-item"><a href="login.jsp">To Login</a></li>
          <li class="list-group-item active"><a href="${pageContext.request.contextPath}/Users">Users</a></li>
          <li class="list-group-item"><a href="${pageContext.request.contextPath}/Employees">Employees</a></li>
        </ul>
      </div>
    </div>

    <div class="flex div_cu_bulinuta">
      <div class="circle">
        <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
          <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
          <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
        </svg>
      </div>
      <div class="div2">
        <div class="container mt-3">
          <div style="display: flex;justify-content: space-between">
            <h2>All Users</h2>
            <form action="${pageContext.request.contextPath}/Users" method="post">
              <button type="submit">Delete Selected Users</button>
              <a href="${pageContext.request.contextPath}/AddUser"><button>Add Users</button></a>
            </form>
          </div>
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>ID</th>
              <th>Username</th>
              <th>Email</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
              <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="${pageContext.request.contextPath}/EditUser?id=${user.id}"><button>Edit User</button></a></td>
                <td><input type="checkbox" name="user_ids" value="${employee.id}"></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

</t:pageTemplate>

<style>
  .div1{
    background-color: white;
    height: 85%;
    width: 100%;
    border-radius: 15px;
    margin-top: 30px;
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
    gap: 40px;
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
  a{
    text-decoration: none;
    color: black;
    background-color: transparent;
  }
</style>
