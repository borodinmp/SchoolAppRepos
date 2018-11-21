<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page>
<#if isCurrentUser>
<div>
    <form method="post" action="text" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <table class="table mx-auto" >
            <thead>
            <tr>
                <th>ID</th>
                <th>Вопрос</th>
                <th>Ответ</th>
            </thead>
        <tbody>
        </tr>

        <#list testResults as testResult>
        <tr>
            <td>${testResult.question_id}</td>
            <td>${testResult.quest}</td>
            <td>
                ${testResult.answer?string('Да', 'Нет')}
            </td>
        </tr>
        </tbody>
        <#else>
        No answers
        </#list>
        </table>
    </form>
</div>
</#if>
</@c.page>
