<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">SchoolApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
            <#if isUser>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main/${currentUserId}">Testing</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-testing/${currentUserId}">My tests</a>
            </li>
            </#if>
            <#if isTeacher>
            <li class="nav-item">
                <a class="nav-link" href="/users-show">Users tests</a>
            </li>
            </#if>

            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>

            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            </#if>

        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
        <div class="navbar-text mr-3"></div>
        <@l.registration />
    </div>
</nav>