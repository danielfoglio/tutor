<#-- @ftlvariable name="tutors" type="java.util.List<edu.uncc.domain.Tutor>" -->
<#-- @ftlvariable name="currentUser" type="edu.uncc.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Tutors</title>
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
        <li><a href="/registrations">View my Registrations</a></li>
    </ul>
</nav>

<h1>List of Tutors</h1>

<table>
    <thead>
    <tr>
        <th>Register</th>
        <th>Specialization</th>
        <th>Course Taught</th>
        <th>Pay Rate</th>
        <th>Availability</th>
        <th>Instruction Mode</th>
    </tr>
    </thead>
    <tbody>
    <#list tutors as tutor>
    <tr>
        <td><a href="/register?tid=${tutor.tid}">${tutor.fname} ${tutor.lname}</a></td>
        <td>${tutor.specialization}</td>
        <td>${tutor.courseTaught}</td>
        <td>${tutor.payRate}</td>
        <td>${(tutor.availability)!}</td>
        <td>${tutor.instructionMode}</td>


    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>