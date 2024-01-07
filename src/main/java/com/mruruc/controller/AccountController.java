package com.mruruc.controller;

import com.mruruc.model.account.BankAccount;
import com.mruruc.service.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "Account Servlet",
        description = "It Should receive data from User Login Servlet and find the account based on userName and send to the JSP.",
        urlPatterns = "/accountServlet"
)
public class AccountController extends HttpServlet {
    private AccountService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service=new AccountService();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long clientID= (Long) request.getAttribute("clientId");


        try {
            BankAccount account = service.getAccount(clientID);
            request.setAttribute("account",account);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/account.jsp");
            requestDispatcher.forward(request,response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}
