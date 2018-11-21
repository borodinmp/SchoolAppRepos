<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <#if chkUsr??><div>Данные на пользователя <b>${user.username}</b> уже имеются в базе</div><#else>
<div>
<br>
    <form method="post" action="test/${user.id}" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <table class="table mx-auto">
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
                <input type="radio" name="${testing.id}" value="1">Да
                <input type="radio" name="${testing.id}" value="2">Нет

                </div>
            </td>
        </tr>
        </tbody>

            <#else>
        No answers
            </#list>
    </table>
        <button class="btn btn-primary mt-3 ml-4" type="submit">Отправить</button>
    </form>
</div>
        </#if>

    </@c.page>