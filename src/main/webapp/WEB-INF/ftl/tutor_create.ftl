<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="edu.uncc.domain.Tutor" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create tutor</title>
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

<h1>Create a new tutor account</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="role" value="TUTOR"/>
    <div>
        <label for="login">Login</label>
        <input type="text" name="login" id="login" value="${form.login}" required autofocus/>
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
        <input type="text" name="fname" id="fname" value="${(form.fname)!}"  />
    </div>

    <div>
        <label for="lname">lname</label>
        <input type="text" name="lname" id="lname" value="${(form.lname)!}"  />
    </div>


    <div>
        <label for="phone">phone</label>
        <input type="number" name="phone" id="phone" value="${(form.phone)!}"  />
    </div>

    <div>
        <label for="payRate">payRate</label>
        <input type="number" name="payRate" id="payRate" value="${(form.payRate)!}"  />
    </div>

    <div>
        <label for="tEmail">tEmail</label>
        <input type="email" name="tEmail" id="tEmail" value="${(form.tEmail)!}"  />
    </div>

    <div>
        <label for="instructionMode">instructionMode</label>
        <select name="instructionMode" id="instructionMode" required>
            <option <#if form.instructionMode == 'Online'>selected</#if>>Online</option>
            <option <#if form.instructionMode == 'Face to Face'>selected</#if>>Face to Face</option>
        </select>
    </div>


    <div>
        <label for="specialization">specialization</label>
        <input type="text" name="specialization" id="specialization" value="${(form.specialization)!}"  />
    </div>

    <div>
        <label for="courseTaught">courseTaught</label>
        <input type="text" name="courseTaught" id="courseTaught" value="${(form.courseTaught)!}"  />
    </div>

    <button type="submit">Create</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>