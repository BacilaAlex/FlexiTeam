<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="LogIn">
    <div class="flex justify-center items-center flex-col gap-md">
        <div class="h-100">

        </div>
        <div>
            <h1 class="title mb-5 pb-0">FlexiTeam</h1>
            <div class="font color-secondary text-center font-md ">Empower Collaboration</div>
        </div>
            <div class="flex flex-center w-05">
                <input class=" w-full h-70 rounded-md shadow text-center" type="text" placeholder="username" >
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right " style="scale: 3; margin-left: -40px; margin-top: 25px" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                </svg>


            </div>

        <input class="w-05 h-70 rounded-md shadow text-center"  type="password" placeholder="password">

    </div>
</t:pageTemplate>
