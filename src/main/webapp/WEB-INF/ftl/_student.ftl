<form role="form" name="formU" action="/user/update/student" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="role" value="USER"/>
    <input type="hidden" name="id" value="${(formU.id)!}"/>

<#if update??>
    <input type="hidden" name="login" value="${(formU.login)!}"/>
    <div>
        <label for="login">Login</label>
        <strong>${formU.login}</strong>
    </div>
<#else>
    <div>
        <label for="login">Login</label>
        <input type="text" name="login" id="login" value="${form.login}" required autofocus/>
    </div>
</#if>

    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <div>
        <label for="fname">fname</label>
        <input type="text" name="fname" id="fname" value="${(formU.fname)!}"  />
    </div>

    <div>
        <label for="lname">lname</label>
        <input type="text" name="lname" id="lname" value="${(formU.lname)!}"  />
    </div>


    <div>
        <label for="phone">phone</label>
        <input type="number" name="phone" id="phone" value="${(formU.phone)!}"  />
    </div>

    <div>
        <label for="degree">degree</label>
        <input type="text" name="degree" id="degree" value="${(formU.degree)!}"  />
    </div>

    <div>
        <label for="degreeStanding">degreeStanding</label>
        <input type="text" name="degreeStanding" id="degreeStanding" value="${(formU.degreeStanding)!}"  />
    </div>

    <div>
        <label for="sEmail">sEmail</label>
        <input type="email" name="sEmail" id="sEmail" value="${(formU.sEmail)!}"  />
    </div>

    <div>
        <label for="courseId">courseId</label>
        <select name="courseId" id="courseId" required>
        <#list courses as course>
            <option <#if course.courseId == (formU.courseId)!>selected</#if>>${course.courseId}</option>
        </#list>
        </select>
    </div>

    <button type="submit">Create/Update</button>
</form>