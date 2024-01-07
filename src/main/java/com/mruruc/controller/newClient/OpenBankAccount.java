package com.mruruc.controller.newClient;
import com.mruruc.model.account.BankAccount;
import com.mruruc.model.client.Client;
import com.mruruc.service.AccountService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(
        name = "Open_New_Bank_Account",
        description = "Creates Bank Account For Client",
        urlPatterns = "/newBankAccount"
)
public class OpenBankAccount extends HttpServlet {
    private AccountService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service=new AccountService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client= (Client) request.getAttribute("client");

        try {
            Long clientId = service.findClientId(client.getLastName(), client.getEmail());

            BankAccount bankAccount =new BankAccount(
                    new BigDecimal(0.0), LocalDateTime.now(),null,clientId
            );
            service.save(bankAccount);
            request.setAttribute("clientID",clientId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
            requestDispatcher.forward(request,response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
