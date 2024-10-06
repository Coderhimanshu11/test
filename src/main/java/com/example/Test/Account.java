package com.example.Test;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "account")

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false,unique = true)
    String accountNo;

    @Column(nullable = false)
    Double deposit;

    @Column(nullable = false)
    LocalDate depositDate;

    @Column(nullable = false)
    Double withdrawalAmount;

    public Account(String accountNo, Double deposit, LocalDate depositDate,Double withdrawalAmount) {
        this.accountNo = accountNo;
        this.deposit = deposit;
        this.depositDate = depositDate;
        this.withdrawalAmount=withdrawalAmount;
    }
}
