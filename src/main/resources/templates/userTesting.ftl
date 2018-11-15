<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page>
<#if isCurrentUser>
<div>
    <form method="post" action="text" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <table class="table mx-auto" style="width: 90%;" >
            <thead>
            <tr>
                <th>ID</th>
                <th>Вопрос</th>
                <th>Ответ</th>
            </thead>
        <tbody>
        </tr>

        <#list testings as testing>
        <tr>
            <td>${testing.id}</td>
            <td>${testing.question}</td>
            <td>
                ${testing.answer?string('yes', 'no')}
            </td>
        </tr>
        </tbody>

        <#else>
        No questions
        </#list>
        </table>
    </form>
</div>
</#if>
</@c.page>
