<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="LogIn">
    <div class="flex justify-center items-center  flex-col gap-md">
        <div class="h-100"></div>
        <div>
            <h1 class="title mb-5 pb-0">FlexiTeam</h1>
            <div class="font color-secondary text-center font-md ">Empower Collaboration</div>
        </div>
        <c:if test="${message != null}">
            <div class="font " style="color: red" role="alert"> ${message}</div>

        </c:if>
        <form method="POST" action="j_security_check" class="flex justify-center flex-col gap-2">
            <input type="text" name="j_username" placeholder="username" class="text-center" required autofocus/>
            <input type="password" name="j_password" placeholder="password" class=" text-center" required/>
            <button type="submit">Log in</button>
        </form>
    </div>
</t:pageTemplate>

