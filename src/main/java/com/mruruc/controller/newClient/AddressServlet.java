package com.mruruc.controller.newClient;

import com.mruruc.authentication.AddressAuth;
import com.mruruc.exceptions.AddressAuthExceptions;
import com.mruruc.model.client.Address;
import com.mruruc.service.AddressService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "Address Servlet",
        description = "Takes the request from address form and save it to database.",
        urlPatterns = "/addressServlet"
)

public class AddressServlet extends HttpServlet {
    private AddressService service;
    private AddressAuth auth;

    @Override
    public void init() throws ServletException {
        super.init();
        this.auth = new AddressAuth();
        this.service = new AddressService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zip = request.getParameter("zip");
        String doorNumber = request.getParameter("doorNo");
        Integer doorNo = Integer.parseInt(doorNumber);


        Address address =
                new Address(country, city, street, zip, doorNo);

        try {
            auth.authNewAddress(address);
            Long addressId = service.create(address);

            if (addressId != null) {
                request.setAttribute("visibility", true);
                request.setAttribute("addressId", addressId.toString());

            } else {
                request.setAttribute("visibility", false);
                request.setAttribute("errorMessage","Address creation failed,try again please.");
            }

        } catch (SQLException exception){
            request.setAttribute("visibility", false);
            request.setAttribute("errorMessage","Database error: "+ exception.getMessage());
        }
        catch (NumberFormatException exception){
            request.setAttribute("visibility", false);
            request.setAttribute("errorMessage","Validation error: please fill all data!");
        }
        catch (AddressAuthExceptions exceptions){
            request.setAttribute("visibility", false);
            request.setAttribute("errorMessage","Validation error: "+exceptions.getMessage());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signin.jsp");
        requestDispatcher.forward(request, response);

    }
}
