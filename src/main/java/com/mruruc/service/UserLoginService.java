package com.mruruc.service;

import com.mruruc.db_management.sqlQueries.userLoginQuery.UsersSQLQuery;
import com.mruruc.exceptions.UserNotFoundException;
import com.mruruc.model.login.UserLogin;
import com.mruruc.repository.CRUDRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static com.mruruc.db_management.dbconnection.DataSource.getConnection;

public class UserLoginService implements CRUDRepository<UserLogin,Long> {

    public UserLoginService(){
    }
    public Long getClientID(String userName) throws SQLException{
        try(PreparedStatement preparedStatement =
                    getConnection().prepareStatement(UsersSQLQuery.getClientIdByUserName)){
            preparedStatement.setString(1,userName);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                   return resultSet.getLong(1);
                }
                throw new UserNotFoundException("User Not Found!");
            }
        }
    }

    @Override
    public boolean save(UserLogin userLogin) throws SQLException {
        try(PreparedStatement preparedStatement =
                    getConnection().prepareStatement(UsersSQLQuery.insertIntoUsers)) {
            preparedStatement.setString(1, userLogin.getUserName());
            preparedStatement.setString(2, userLogin.getPassword());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(userLogin.getLastLogin()));
            preparedStatement.setBoolean(4, userLogin.getAccountLocked());
            preparedStatement.setLong(5, userLogin.getClientID());
            int i = preparedStatement.executeUpdate();
            return i ==1;
        }
    }

    @Override
    public List<UserLogin> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<UserLogin> findById(Long aLong) throws SQLException {
        return Optional.empty();
    }

    @Override
    public UserLogin update(Long aLong, UserLogin userLogin) throws SQLException {
        return null;
    }

    @Override
    public Long delete(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public boolean isExists(Long aLong) throws SQLException {
        return false;
    }
}
