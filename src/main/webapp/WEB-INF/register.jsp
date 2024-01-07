<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,love bank">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
    </head>
    <body>
        <h2>Last Step Almost Have Love Bank</h2>

        <%
           Long clientId =(Long) request.getAttribute("clientID");
        %>

        <form action="<%=request.getContextPath()%>/createNewUser" method="post" autocomplete="on">

            <label for="userName">User Name</label><br/>
            <input type="text" id="userName" name="userName" required><br/>

            <label for="password">Password</label><br/>
            <input type="password" id="password" name="password" required><br/>

            <input type="hidden" name="clientId" value="<%=clientId%>">

            <input type="submit" value="Register">

        </form>

    </body>
</html>
