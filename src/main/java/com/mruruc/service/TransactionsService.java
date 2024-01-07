package com.mruruc.service;

import com.mruruc.db_management.dbconnection.DataSource;
import com.mruruc.db_management.sqlQueries.transactionsQueries.TransactionsSQLQuery;
import com.mruruc.model.transaction.Transaction;
import com.mruruc.model.transaction.TransactionType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionsService {

    public TransactionsService(){}

    public List<Transaction> getAll(UUID accountId) throws SQLException {
        List<Transaction> transactions=new ArrayList<>();
        try(PreparedStatement preparedStatement
                    = DataSource.getConnection().prepareStatement(TransactionsSQLQuery.getAll)){
            preparedStatement.setObject(1,accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    transactions.add(
                      new Transaction(
                              TransactionType.valueOf(resultSet.getString(1)),
                              resultSet.getDouble(2),
                              resultSet.getTimestamp(3).toLocalDateTime()
                      )
                    );
                }
            }
        }
        return transactions;
    }
}
