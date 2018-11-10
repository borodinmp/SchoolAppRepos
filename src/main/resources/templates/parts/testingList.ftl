<#include "security.ftl">
<div>
    <form method="post" action="text" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <table class="table">
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
                <@s.radio label="" name="rbutton" list="#@java.util.LinkedHashMap@{true:'Frob it',false:'Leave unfrobbed'}" />
<#--                <input type="radio" name="rbutton" value="1">Да
                <input type="radio" name="rbutton" value="2">Нет-->
            </td>
        </tr>
        </tbody>
        <#else>
        No questions
        </#list>
    </table>
        <button class="btn btn-primary mt-3" type="submit">Отправить</button>
    </form>
</div>