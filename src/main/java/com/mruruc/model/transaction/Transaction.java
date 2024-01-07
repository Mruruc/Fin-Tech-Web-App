package com.mruruc.model.transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Transaction {
    private Long id;
    private TransactionType type;
    private Double amount;
    private LocalDateTime date;
    private UUID accountId;
    private Long clientId;

    public Transaction(Long id, TransactionType type, Double amount, LocalDateTime date, UUID accountId, Long clientId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.clientId = clientId;
    }
    public Transaction(TransactionType type, Double amount, LocalDateTime date) {
        this.type = type;
        this.amount = amount;
        this.date = date;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", accountId=" + accountId +
                ", clientId=" + clientId +
                '}';
    }
}
