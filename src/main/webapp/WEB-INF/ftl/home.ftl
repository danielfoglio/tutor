<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="edu.uncc.domain.CurrentUser" -->
<#-- @ftlvariable name="student" type="edu.uncc.domain.Student" -->
<#-- @ftlvariable name="tutor" type="edu.uncc.domain.Tutor" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>

        <li><a href="/user/create">Create account</a></li>

    <#if student?? >
        <li>User ${student.fname} ${student.lname} Created/Updated!</a></li>
    </#if>
    <#if tutor?? >
        <li>User ${tutor.fname} ${tutor.lname} Created/Updated!</a></li>
    </#if>

    <#if currentUser?? && currentUser.role == "TUTOR">
        <li><a href="/users">View your Students</a></li>
    </#if>
    <#if currentUser?? && currentUser.role == "USER">
        <li><a href="/users/TUTOR">View all tutors</a></li>
    </#if>

    </ul>
</nav>
</body>
</html>