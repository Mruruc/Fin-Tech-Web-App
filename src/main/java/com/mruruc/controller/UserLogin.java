package com.mruruc.controller;

import com.mruruc.authentication.LoginAuth;
import com.mruruc.exceptions.ClientNotFoundException;
import com.mruruc.exceptions.InvalidInputException;
import com.mruruc.service.UserLoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "UserLogin",
        description = "User Login Servlet.",
        urlPatterns = {"/login"}
)
public class UserLogin extends HttpServlet {
    private UserLoginService service;
    private LoginAuth auth;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service=new UserLoginService();
        this.auth=new LoginAuth();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{


        // extract parameter
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try {
                Long clientID = auth.authLogin(userName, password);
                if(clientID != null){
                    request.setAttribute("userName",userName);
                    request.setAttribute("clientId",clientID);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/accountServlet");
                    requestDispatcher.forward(request,response);
                }
                else {
                    request.setAttribute("errorMessage","Invalid Password Or User Name!");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(request,response);
                }
        }
        catch (NullPointerException | InvalidInputException  | ClientNotFoundException exception){
            request.setAttribute("errorMessage",exception.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage","please try again!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request,response);
        }

    }

}
