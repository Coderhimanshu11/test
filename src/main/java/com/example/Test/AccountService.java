package com.example.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

    private static final double INTEREST_RATE=0.07;
    public Account createAccount(String accountNo, Double deposit, LocalDate depositDate,double withdrawalAmount){
        if (accountRepo.findByAccountNo(accountNo) != null) {
            throw new IllegalArgumentException("Account number already exists");
        }
        Account ac=new Account(accountNo,deposit,depositDate,withdrawalAmount);
         return accountRepo.save(ac);
    }

    public DTO calculateInterest(String accountNo){
        Account account=accountRepo.findByAccountNo(accountNo);
        if (account==null){
            throw new IllegalArgumentException("account not found.");
        }
         LocalDate today=LocalDate.now();
        long dayBetween = ChronoUnit.DAYS.between(account.getDepositDate(),today);
        double timeInYears=dayBetween/365.0;
        Double calculateInterest=account.getDeposit()*INTEREST_RATE*timeInYears;
        return new DTO(accountNo,calculateInterest);
    }


}
