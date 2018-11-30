<#import "parts/common.ftl" as c>
<@c.page>
<H5>Список обучающихся</H5>
<br>
<table class="table html-editor-align-left" style="width: 50%">
    <thead>
    <tr>
        <th>ФИО</th>
        <th>Результат</th>
        <th>Сброс</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.fullName}</td>
        <td><a href="/all-user-testing/${user.id}">Показать результаты теста</a></td>
        <td>
            <form method="post" action="/delete/${user.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-primary mt-3 ml-4" type="submit">Удалить</button>
            </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>