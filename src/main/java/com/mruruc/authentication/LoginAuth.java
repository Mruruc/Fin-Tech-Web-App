package com.mruruc.authentication;

import com.mruruc.db_management.dbconnection.DataSource;
import com.mruruc.db_management.sqlQueries.userLoginQuery.UsersSQLQuery;
import com.mruruc.exceptions.ClientNotFoundException;
import com.mruruc.exceptions.InvalidInputException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuth {

    public LoginAuth(){

    }

    public Long authLogin(String userName,String password) throws InvalidInputException, SQLException {
        AuthUtils.checkForBlankAndEmptyAndNull(userName,InvalidInputException.class,"User Name Is Empty!");
        AuthUtils.checkForBlankAndEmptyAndNull(password,InvalidInputException.class,"Empty! Password ");

        // database check
        try(PreparedStatement preparedStatement
                    = DataSource.getConnection().prepareStatement(UsersSQLQuery.getClientIdByUserNameANDPassword)){
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return resultSet.getLong(1);
                }
                throw new ClientNotFoundException("There is no client with specified user name and password!");
            }
        }
    }
}
