<#import "parts/common.ftl" as c>
<@c.page>
<H5>Список пользователей</H5>
<br>
<table class="table table-sm" style="width: 50%">
    <thead>
    <tr>
        <th>Логин</th>
        <th>ФИО</th>
        <th>Роль</th>
        <th>Редактор</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
<tr>
    <td>${user.username}</td>
    <td>${user.fullName}</td>
    <td><#list user.roles as role> ${role} <#sep>, </#list> </td>
    <td><a href = "/user/${user.id}">edit</a></td>
</tr>
</#list>
    </tbody>
</table>
</@c.page>