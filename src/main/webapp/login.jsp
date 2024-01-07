<%@ page contentType="text/html; charset=UTF-8"
         language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,love bank">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
    </head>
    <body style="text-align: center">

         <h1>Welcome, Love Bank!</h1>

         <form action="<%=request.getContextPath()%>/login"
               method="post" enctype="application/x-www-form-urlencoded" autocomplete="on" >

             <label for="userName">User Name:</label> <br/>
             <input type="text" id="userName" name="userName" required> <br/>
             <label for="password">Password:</label> <br/>
             <input type="password" id="password" name="password" required> <br/>
             <input type="submit" value="Login">
         </form>

         <div>
             <% if(request.getAttribute("errorMessage") != null) {%>
             <p style="color: red;" >
                 <%= request.getAttribute("errorMessage")%>
             </p>
             <% } %>
         </div>

         <br/>
         <br/>
         <div>
             <button>
                 <a href="<%=request.getContextPath()%>/forgotpassword.jsp">
                     Forgot Password?
                 </a>
             </button>
         </div>
         <br/>
         <br/>
         <div>
             <button type="button" >
                 <a href="<%=request.getContextPath()%>/signin.jsp">
                     Sign in
                 </a>
             </button>
         </div>
    </body>
</html>
