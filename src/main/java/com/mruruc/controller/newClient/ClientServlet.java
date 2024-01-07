package com.mruruc.controller.newClient;

import com.mruruc.authentication.ClientAuth;
import com.mruruc.exceptions.ClientAuthException;
import com.mruruc.model.client.Client;
import com.mruruc.model.client.Gender;
import com.mruruc.service.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(
        name = "Client Servlet",
        description = "Registers the new Client",
        urlPatterns = "/clientServlet"
)
public class ClientServlet extends HttpServlet {

    private ClientAuth auth;
    private ClientService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.auth=new ClientAuth();
        this.service=new ClientService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirt = req.getParameter("dob");
        LocalDate dob = LocalDate.parse(dateOfBirt);

        String genderStr = req.getParameter("gender");
        Gender gender = Gender.valueOf(genderStr);

        String phone1 = req.getParameter("phone1");
        String phone2 = req.getParameter("phone2");

        String email = req.getParameter("email");

        String addressIdStr = req.getParameter("addressId");
        Long addressId = Long.parseLong(addressIdStr);

        Client client=new Client(
                firstName,lastName,dob,gender,
                List.of(phone1,phone2),email,addressId
        );

        try {
            auth.authNewClient(client);
            boolean save = service.save(client);
            if(save){
                req.setAttribute("client",client);
                forwardToPage(req,resp,"/newBankAccount");
            }else {
                setErrorMessage(req,"Unable to save client information.");
                forwardToPage(req,resp,"/signin.jsp");
            }
        } catch (SQLException exception) {
            setErrorMessage(req,"An error occurred while processing your request." + exception.getMessage());
            forwardToPage(req,resp,"/signin.jsp");
        }
        catch (ClientAuthException exception){
            setErrorMessage(req,exception.getMessage());
            forwardToPage(req,resp,"/signin.jsp");
        }
    }

    private void setErrorMessage(HttpServletRequest request,String message){
        request.setAttribute("errorMessage",message);
    }

    private void forwardToPage(HttpServletRequest request,HttpServletResponse response,String page) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request,response);
    }

}
