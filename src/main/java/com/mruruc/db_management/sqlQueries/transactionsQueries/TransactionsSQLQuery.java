package com.mruruc.db_management.sqlQueries.transactionsQueries;

public class TransactionsSQLQuery {
    public static final String getAll="SELECT transaction_type, amount, date_time FROM transaction" +
                                        " WHERE account_id = ? ";


    private TransactionsSQLQuery() {}
}
