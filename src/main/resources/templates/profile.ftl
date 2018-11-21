<#import "parts/common.ftl" as c>

<@c.page>
<H5>Профиль:  ${username}</H5>
<br>
<form method="post">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> ФИО:</label>
        <div class="col-sm-6">
            <input value="<#if fullname??>${fullname}</#if>" type="text"  name="fullName" class="form-control ${(fullNameError??)?string('is-invalid', '')}"
                   placeholder="ФИО">
            <#if fullNameError??>
                      <div class="invalid-feedback">
                          ${fullNameError}
                      </div>
            </#if>
        </div>
    </div>

       <div class="form-group row">
           <label class="col-sm-2 col-form-label"> Пароль:</label>
           <div class="col-sm-6">
               <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"/>
            <#if passwordError??>
                      <div class="invalid-feedback">
                          ${passwordError}
                      </div>
            </#if>
           </div>
       </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Повторите пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password2" class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Retype password"/>
            <#if passwordError??>
                      <div class="invalid-feedback">
                          ${passwordError}
                      </div>
            </#if>
            </div>
        </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Сохранить</button>
</form>
</@c.page>