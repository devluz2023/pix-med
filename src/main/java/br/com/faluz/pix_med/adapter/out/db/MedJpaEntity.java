// adapter/out/db/MedJpaEntity.java
package br.com.faluz.pix_med.adapter.out.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "med_requests")
public class MedJpaEntity {

    @Id
    private String id;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 20)
    private String status;

    // Construtor vazio obrigatório pelo JPA
    public MedJpaEntity() {}

    // Construtor completo
    public MedJpaEntity(String id, String transactionId, BigDecimal amount, String status) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}