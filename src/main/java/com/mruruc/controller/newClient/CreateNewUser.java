package com.mruruc.controller.newClient;

import com.mruruc.authentication.UserAuth;
import com.mruruc.exceptions.UserAuthExceptions;
import com.mruruc.model.login.UserLogin;
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
        name = "Create New User",
        description = "Create New Application User.",
        urlPatterns = "/createNewUser"
)
public class CreateNewUser extends HttpServlet {
    private UserAuth auth;
    private UserLoginService service;


    @Override
    public void init() throws ServletException {
        super.init();
        this.auth=new UserAuth();
        this.service=new UserLoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String clientIdStr = req.getParameter("clientId");
        Long clientId = Long.parseLong(clientIdStr);


        UserLogin userLogin=new UserLogin(userName,password,clientId);

        try {
            auth.authNewUser(userLogin);
            boolean result = service.save(userLogin);

            if(result){
                req.setAttribute("clientId",clientId);
                req.setAttribute("userName",userName);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/accountServlet");
                requestDispatcher.forward(req,resp);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (UserAuthExceptions ex){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }

    }

}
