<#--
<div class="collapse <#if testing??>show</#if> mt-3" id="collapseExample"
     <div class="form-group">
         <form method="post" action="text" enctype="multipart/form-data">
             <input type="hidden" name="_csrf" value="${_csrf.token}"/>
             <div class="form-group">
                 Вопрос<input type="text" class="form-control ${(questionError??)?string('is-invalid', '')}"
                                                value = "<#if testing ??>${testing.question}</#if>"name="question" placeholder="Введите вопрос">
                 <#if questionError??>
                      <div class="invalid-feedback">
                          ${questionError}
                      </div>
                 </#if>
             </div>
             <input type="hidden" name="id" value="<#if testing??>${testing.id}</#if>" />
             <div class="form-group">
             <button class="btn btn-primary" type="submit">Save info</button>
             </div>
         </form>
     </div>
</div>-->

