package com.mruruc.controller;

import com.mruruc.model.transaction.Transaction;
import com.mruruc.service.TransactionsService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet(
        name = "Transaction",
        description = "Transaction Servlet Will Forward the Response to Transaction JSP",
        urlPatterns = "/transactions"
)
public class Transactions extends HttpServlet {
    private TransactionsService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service=new TransactionsService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accountId = request.getParameter("accountId");
        UUID uuid = UUID.fromString(accountId);

        if(uuid == null){
            response.sendRedirect("/accountServlet");
        }
        List<Transaction> transactions = null;
        try {
            transactions = service.getAll(uuid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("transactions",transactions);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/transaction.jsp");

        dispatcher.forward(request,response);

    }

}
