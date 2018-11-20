<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Login:</label>
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
        <label class="col-sm-2 col-form-label">Full name:</label>
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
        <label class="col-sm-2 col-form-label"> Password:</label>
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
            <label class="col-sm-2 col-form-label"> Retype Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password2" class="form-control ${(password2Error??)?string('is-invalid', '')}" placeholder="Password"/>
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
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
    <button class="btn btn-primary" type="submit"> <#if isRegisterForm>Create<#else>Sign in</#if></button>
</form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if Session.SPRING_SECURITY_CONTEXT??>Sign Out<#else>Sign In</#if></button>
    </form>
</#macro>