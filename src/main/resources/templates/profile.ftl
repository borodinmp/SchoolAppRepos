<#import "parts/common.ftl" as c>

<@c.page>
<H5>${username}</H5>
    ${message?ifExists}
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
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Retype Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password2" class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"/>
            <#if passwordError??>
                      <div class="invalid-feedback">
                          ${passwordError}
                      </div>
            </#if>
            </div>
        </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Save</button>
</form>
</@c.page>