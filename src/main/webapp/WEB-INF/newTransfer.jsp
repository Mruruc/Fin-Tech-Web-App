<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Transfer</title>
    </head>
    <body>
        <form id="transferForm" action="<%=request.getContextPath()%>/transferServlet" method="post" >
            <input type="text"  name="accountId" placeholder="Account Number"> <br/>
            <input type="number"  name="amount" placeholder="Amount"><br/>
            <input type="text"  name="description" placeholder="Description Optional">
        </form>

    </body>
</html>
