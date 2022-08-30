package com.alam.fraud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "fraud_id_sequence")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}