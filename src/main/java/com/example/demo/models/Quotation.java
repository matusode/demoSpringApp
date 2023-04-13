package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private LocalDate beginingOfInsurance;
    private Float insuredAmount;
    private LocalDate dateOfSigningMortgage;
    @ManyToOne
    private Customer customer;

    public Quotation(UUID uuid, LocalDate beginingOfInsurance, Float insuredAmount, LocalDate dateOfSigningMortgage, Customer customer) {
        this.uuid = uuid;
        this.beginingOfInsurance = beginingOfInsurance;
        this.insuredAmount = insuredAmount;
        this.dateOfSigningMortgage = dateOfSigningMortgage;
        this.customer = customer;
    }

    public Quotation() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getBeginingOfInsurance() {
        return beginingOfInsurance;
    }

    public void setBeginingOfInsurance(LocalDate beginingOfInsurance) {
        this.beginingOfInsurance = beginingOfInsurance;
    }

    public Float getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(Float insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public LocalDate getDateOfSigningMortgage() {
        return dateOfSigningMortgage;
    }

    public void setDateOfSigningMortgage(LocalDate dateOfSigningMortgage) {
        this.dateOfSigningMortgage = dateOfSigningMortgage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
