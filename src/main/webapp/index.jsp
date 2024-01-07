<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,Home Page">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/home-page.css">
        <title>Love Bank</title>
    </head>
    <body>
            <header class="home-header">
                <div class="logo">Love Bank</div>
                <div class="home">
                    <a href="${pageContext.request.contextPath}/index.jsp">
                        Home
                    </a>
                </div>
                <div class="about-us">Learn More About Us</div>
                <div class="log-in">
                    <button>
                        <a href=" <%=request.getContextPath()%>/login.jsp" > Log in </a>
                    </button>
                </div>
                <div class="sign-in">
                    <button>
                        <a href="<%=request.getContextPath()%>/signin.jsp"> Sign in </a>
                    </button>
                </div>
            </header>
            <main>
                <div class="background">
                   <img src="${pageContext.request.contextPath}/style/images/LoveBank.png" alt="LoveBank" class="love-bank-image">
                </div>
            </main>
            <footer>
                <div>
                    All rights reserved &#169<a href="https://github.com/Mruruc" target="_blank">Mr.Uruc</a>
                </div>
            </footer>
    </body>
</html>