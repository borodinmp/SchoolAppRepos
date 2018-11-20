<#import "parts/common.ftl" as c>
<@c.page>
<H5>Список пользователей</H5>
<table class="table html-editor-align-left" style="width: 50%">
    <thead>
    <tr>
        <th>Name</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
<tr>
    <td>${user.fullName}</td>
    <td><a href = "/all-user-testing/${user.id}">Показать результаты теста</a></td>
</tr>
</#list>
    </tbody>
</table>
</@c.page>