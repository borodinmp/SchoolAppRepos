<#include "security.ftl">
<div>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Вопрос</th>
            <th>Ответ</th>
            <th>Автор</th>
            <th>Редактировать</th>
        </thead>
    <tbody>
    </tr>
        <#list testings as testing>
        <tr>
            <td>${testing.id}</td>
            <td>${testing.question}</td>
            <td>${testing.answer?then('y','n')}</td>
            <td>
                <a href="/user-testing/${testing.author.id}">${testing.authorName}</a></td>
            <td> <#if testing.author.id == currentUserId>
                <a class="btn btn-primary" href="/user-testing/${testing.author.id}?testing=${testing.id}">Edit</a>
            </#if></td>
        </tr>
        </tbody>
        <#else>
        No questions
        </#list>
    </table>
</div>