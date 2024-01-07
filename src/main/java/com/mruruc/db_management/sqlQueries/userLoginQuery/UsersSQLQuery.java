package com.mruruc.db_management.sqlQueries.userLoginQuery;

public class UsersSQLQuery {
    public static final String insertIntoUsers="INSERT INTO users(user_name,password,last_login,account_locked,client_id) " +
                                               " VALUES(?,?,?,?,?) ";
    public static String getClientIdByUserName=" SELECT client_id FROM users WHERE user_name LIKE ? ";
    public static String getClientIdByUserNameANDPassword="SELECT client_id FROM users WHERE user_name LIKE ? AND password LIKE ? ";

    private UsersSQLQuery(){}
}
