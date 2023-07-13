package com.example.springsecurity.controller;

import com.example.springsecurity.model.Loans;
import com.example.springsecurity.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoansController {

        @Autowired
        private LoanRepository loanRepository;

        @GetMapping("/myLoans")
        public List<Loans> getLoanDetails(@RequestParam int id) {
            List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
            if (loans != null ) {
                return loans;
            }else {
                return null;
            }
        }


}
