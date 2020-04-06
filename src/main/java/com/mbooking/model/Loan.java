package com.mbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private Long id;
    private LoanStatus status;

    Loan(Long id, LoanStatus status) {
        this.id = id;
        this.status = status;
    }

    Long getId() {
        return id;
    }

    LoanStatus getStatus() {
        return status;
    }
}
