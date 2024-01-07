<%@ page import="com.mruruc.model.account.BankAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,love bank">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/account.css">
        <title>Bank Account</title>

    </head>
    <body style="background-image: url('${pageContext.request.contextPath}/style/images/LoveBank.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;">


    <%
             BankAccount account= (BankAccount) request.getAttribute("account");
             String userName = (String) request.getAttribute("userName");
             userName=userName.toUpperCase();
         %>
        <header>
            <h1>
                Hello Dear <%=userName%>
            </h1>

        </header>

         <br/>
         <main>
             <div>
                 Balance:
                 <%=account.getBalance()%> PLN
             </div>
             <div>
                 Account-Number:
                 <%=account.getId()%>
             </div>

             <form action="<%=request.getContextPath()%>/transactions" method="post">
                 <input type="hidden" name="accountId" value="<%= account.getId() %>" hidden="hidden">
                 <input type="submit" value="View Transactions">
             </form>



            <button>
                <a href="<%=request.getContextPath()%>/newTransferServlet">
                    New Transfer
                </a>
            </button>

         </main>
         <footer>
             <div>
                 All rights reserved &#169<a href="https://github.com/Mruruc" target="_blank">Mr.Uruc</a>
             </div>
         </footer>
    </body>
</html>
