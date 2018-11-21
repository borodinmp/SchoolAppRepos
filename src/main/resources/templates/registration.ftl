<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-1"><H5>Добавить нового пользователя</H5></div>
<br>
    ${testing?ifExists}
    <@l.login "/registration" true />
</@c.page>