<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="edu.uncc.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create account</title>
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

<h1>Create account</h1>
<ul>
    <li><a href="/user/create/student">Student Account</a></li>
    <li><a href="/user/create/tutor">Tutor Account</a></li>
</ul>
</body>
</html>