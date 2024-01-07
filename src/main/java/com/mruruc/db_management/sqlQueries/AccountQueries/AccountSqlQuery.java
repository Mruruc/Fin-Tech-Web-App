package com.mruruc.db_management.sqlQueries.AccountQueries;

public class AccountSqlQuery {
    public static final String createNewBankAccount="INSERT INTO bank_account(balance,open_date,close_date,client_id)" +
                                                     "VALUES(?,?,?,?)";
    public static final String getCreatedAccountList="SELECT * FROM bank_account";

    public static final String getClientID="SELECT client_id FROM client" +
                                            " WHERE last_name LIKE ? AND email LIKE ?  ";
    public static final String getAccount="SELECT account_id,balance,client_id FROM bank_account " +
                                            " WHERE client_id = ? ";
    public static final String updateAccount="UPDATE bank_account " +
                                              " SET balance= ? ," +
                                              " close_date= ? " +
                                              " WHERE account_id = ? " +
                                              " RETURNING * ";
    public static final String deleteBankAccount="DELETE FROM bank_account WHERE account_id = ? RETURNING account_id ";
    public static final String isExists="SELECT true FROM bank_account WHERE account_id = ? ";


    private AccountSqlQuery(){}
}
