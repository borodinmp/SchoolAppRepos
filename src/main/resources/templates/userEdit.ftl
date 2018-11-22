<#import "parts/common.ftl" as c>
<@c.page>
<H6>Логин</H6>
<div>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}"/>
</div>
<div>
    <br>
    <H6>Список ролей</H6>
</div>
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
            </label>
        </div>
    </#list>
    <input type="hidden" name="userid" value="${user.id}"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Сохранить</button>

</form>
</@c.page>