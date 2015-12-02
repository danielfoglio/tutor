
<#-- @ftlvariable name="currentUser" type="edu.uncc.domain.CurrentUser" -->
<#-- @ftlvariable name="students" type="java.util.Collection<edu.uncc.domain.Student>" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
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
        <li><a href="/user/create">Create a new user</a></li>
    </ul>
</nav>


<h1>List of Users</h1>


<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <#list students as student>
    <tr>
        <td>${student.sid}</a></td>
        <td>${student.sEmail}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>