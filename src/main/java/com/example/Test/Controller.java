package com.example.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/accounts")
public class Controller {

    @Autowired
    AccountService accountService;
    @PostMapping("/add")
    public String createAccount(@RequestParam String accountNo,
                                @RequestParam Double deposit,
                                @RequestParam String depositDate,
                                @RequestParam Double withdrawalAmount){
        accountService.createAccount(accountNo,deposit, LocalDate.parse(depositDate),withdrawalAmount);
        return "Account created successfully";

    }
    @GetMapping("/calculateInterest")
    public DTO calculateInterest(@RequestParam String accountNo){
        Double interest= accountService.calculateInterest(accountNo).getInterestRate();
        return new DTO(accountNo,interest);
    }
}
