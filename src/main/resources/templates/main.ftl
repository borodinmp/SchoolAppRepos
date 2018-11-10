<#import "parts/common.ftl" as c>
    <@c.page>

<#--<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <select name="selectFilter" class="form-control ml-2" value="${selectFilter?ifExists}">
                <option name="orgAll" value="1">Все поля</option>
                <option name="orgName" value="2">Вопрос</option>
            </select>
            <input type="text" name="filter" value="${filter?ifExists}" placeholder="Search" class="form-control ml-2">
            <button type="submit" class="btn btn-primary">Найти</button>
        </form>
    </div>
</div>
     <div class="form-group">
         <form method="post" action="text" enctype="multipart/form-data">
             <input type="hidden" name="_csrf" value="${_csrf.token}"/>
             <div class="form-group">
                 Вопрос<input type="text" class="form-control ${(questionError??)?string('is-invalid', '')}"
                                                value = "<#if testing??>${testing.question}</#if>"name="question" placeholder="Введите вопрос">
                 <#if questionError??>
                      <div class="invalid-feedback">
                          ${questionError}
                      </div>
                 </#if>
             </div>
             <div class="form-group">
                 Да<input class="form-control" value = "1" type="radio" name="rbutton">
                 Нет<input class="form-control" value = "2" type="radio" name="rbutton">
             </div>

             <button class="btn btn-primary mt-3" type="submit">Отправить</button>
         </form>
     </div>-->

<br>

<div>Удаление элементов</div>
<div class="form-inline">
<form method="post" action="delete">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="text" name="id">
    <button type="submit">Удалить</button>
</form>
</div>
    <br>
        <#include "parts/testingEdit.ftl"/>
        <#include "parts/testingList.ftl"/>

</@c.page>