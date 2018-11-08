<#import "parts/common.ftl" as c>
<@c.page>
<#if isCurrentUser>
    <#include "parts/testingEdit.ftl" />
</#if>
    <#include "parts/testingList.ftl" />
</@c.page>
