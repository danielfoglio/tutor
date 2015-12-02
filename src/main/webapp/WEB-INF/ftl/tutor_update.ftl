<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="formU" type="edu.uncc.domain.TutorForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Update tutor</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Update tutor account</h1>

<form role="form" name="formU" action="/user/update/tutor" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="role" value="TUTOR"/>
    <input type="hidden" name="id" value="${(formU.id)!}"/>
    <input type="hidden" name="login" value="${(formU.login)!}"/>
    <div>
        <label for="login">Login</label>
        <strong>${(formU.login)!}</strong>
    </div>
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
        <label for="payRate">payRate</label>
        <input type="number" name="payRate" id="payRate" value="${(formU.payRate)!}"  />
    </div>

    <div>
        <label for="tEmail">tEmail</label>
        <input type="email" name="tEmail" id="tEmail" value="${(formU.tEmail)!}"  />
    </div>

    <div>
        <label for="instructionMode">instructionMode</label>
        <select name="instructionMode" id="instructionMode" required>
            <option <#if formU.instructionMode == 'Online'>selected</#if>>Online</option>
            <option <#if formU.instructionMode == 'Face to Face'>selected</#if>>Face to Face</option>
        </select>
    </div>


    <div>
        <label for="specialization">specialization</label>
        <input type="text" name="specialization" id="specialization" value="${(formU.specialization)!}"  />
    </div>

    <div>
        <label for="courseTaught">courseTaught</label>
        <input type="text" name="courseTaught" id="courseTaught" value="${(formU.courseTaught)!}"  />
    </div>

    <button type="submit">Update</button>


</form>

<@spring.bind "formU" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>