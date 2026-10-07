package br.com.faluz.pix_med.adapter.in.web.dto;

import java.math.BigDecimal;

public class MedRequestDto {
    private String transactionId;
    private BigDecimal amount;

    // Getters e Setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}