<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page>
<#if isTeacher>
<div>
    <div>${fullName}</div>
    <form method="post" action="text">
        <table class="table mx-auto" style="width: 90%; " >
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
        No questions
        </#list>
        </table>
    </form>
</div>
</#if>
</@c.page>
