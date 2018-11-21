<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Логин:</label>
        <div class="col-sm-6">
            <input type="text" name="username" value="<#if user??>${user.username}</#if>" class="form-control ${(usernameError??)?string('is-invalid', '')}" placeholder="Login"/>
            <#if usernameError??>
                      <div class="invalid-feedback">
                          ${usernameError}
                      </div>
            </#if>
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">ФИО:</label>
        <div class="col-sm-6">
            <input type="text" name="fullName" value="<#if user??>${user.fullName}</#if>" class="form-control ${(fullNameError??)?string('is-invalid', '')}" placeholder="Full name"/>
            <#if fullNameError??>
                      <div class="invalid-feedback">
                          ${fullNameError}
                      </div>
            </#if>
        </div>
    </div>
    </#if>
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
    <#if isRegisterForm>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Повторите пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password2" class="form-control ${(password2Error??)?string('is-invalid', '')}" placeholder="Retype password"/>
            <#if password2Error??>
                      <div class="invalid-feedback">
                          ${password2Error}
                      </div>
            </#if>
            </div>
        </div>
    <div class="form-group row">
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit"> <#if isRegisterForm>Создать<#else>Вход</#if></button>
    <div><br>
        <#if !isRegisterForm><a href="/registration">Добавить нового пользователя</a></#if>
    </div>
</form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if Session.SPRING_SECURITY_CONTEXT??>Выход<#else>Вход</#if></button>
    </form>
</#macro>