// domain/entity/MedRequest.java
package br.com.faluz.pix_med.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class MedRequest {
    private String id;
    private String transactionId;
    private BigDecimal amount;
    private String status;

    // Construtor usado ao criar uma nova requisição (gera ID novo)
    public MedRequest(String transactionId, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = "REQUESTED";
    }

    // Construtor usado pelo Adapter ao carregar do banco (preserva ID e status reais)
    public MedRequest(String id, String transactionId, BigDecimal amount, String status) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

    public void approve() {
        this.status = "APPROVED";
    }

    // Getters obrigatórios
    public String getId() { return id; }
    public String getTransactionId() { return transactionId; }
    public BigDecimal getAmount() { return amount; }
    public String getStatus() { return status; }
}