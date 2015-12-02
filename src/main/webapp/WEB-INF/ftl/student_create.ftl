<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="edu.uncc.domain.Student" -->
<#-- @ftlvariable name="courses" type="java.util.List<edu.uncc.domain.Courses>" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create student</title>
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

<h1>Create a new student account</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="role" value="USER"/>
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
        <label for="degree">degree</label>
        <input type="text" name="degree" id="degree" value="${(form.degree)!}"  />
    </div>

    <div>
        <label for="degreeStanding">degreeStanding</label>
        <input type="text" name="degreeStanding" id="degreeStanding" value="${(form.degreeStanding)!}"  />
    </div>

    <div>
        <label for="sEmail">sEmail</label>
        <input type="email" name="sEmail" id="sEmail" value="${(form.sEmail)!}"  />
    </div>

    <div>
        <label for="courseId">courseId</label>
        <select name="courseId" id="courseId" required>
        <#list courses as course>
            <option><#if course.courseId == (form.courseId)!>selected</#if>${course.courseId}</option>
        </#list>
        </select>
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