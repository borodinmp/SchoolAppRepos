<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<@c.page>
    <#if isTeacher>
<div>
    <div><H5>${fullName}</H5></div>
    <br>
    <form method="post" action="text">
        <table class="table mx-auto" style="width: 90%; ">
            <thead>
            <tr>
                <th>№</th>
                <th>Вопрос</th>
                <th>Ответ</th>
                <th>Ключ</th>
            </thead>
        <tbody>
        </tr>

        <#list testResults as testResult>
        <tr>
            <td>${testResult.question_id}</td>
            <td>${testResult.quest}</td>
            <td style="<#if testResult.answer != testResult.checkQuest>background-color: lightsalmon<#else>background-color: lightgreen</#if>">
                ${testResult.answer?string('Да', 'Нет')}
            </td>
            <td>
                ${testResult.checkQuest?string('Да', 'Нет')}
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
