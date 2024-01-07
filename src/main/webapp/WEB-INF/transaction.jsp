<%@ page import="com.mruruc.model.transaction.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,love bank">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Transactions</title>
    </head>
    <body>
        <table>
            <thead>
                 <tr>
                     <th>Type</th>
                     <th>Amount</th>
                     <th>Date</th>
                 </tr>
            </thead>
            <tbody>

                     <%
                         List<Transaction> transactions =
                                 (List<Transaction>) request.getAttribute("transactions");
                         for (Transaction transaction:transactions ) {
                             out.println("<tr>");
                             out.print("<td>" +transaction.getType().toString()+ "</td>");
                             out.print("<td>" +transaction.getAmount()+ "</td>");
                             out.print("<td>" +transaction.getDate()+ "</td>");
                             out.println("</tr>");
                         }
                     %>
            </tbody>
        </table>
    </body>
</html>
