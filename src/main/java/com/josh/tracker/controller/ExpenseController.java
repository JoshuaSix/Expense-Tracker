package com.josh.tracker.controller;

import com.josh.tracker.DTO.ExpenseRequestDTO;


import com.josh.tracker.service.ExpenseServiceImp_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ExpenseController {

    @Autowired
    private ExpenseServiceImp_1 expenseService;

    @PostMapping
    public ResponseEntity<?> addExpense(
            @RequestBody ExpenseRequestDTO dto,
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                expenseService.addExpense(dto, userId)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserExpenses(@PathVariable Long userId){

        return ResponseEntity.ok(
                expenseService.getExpensesByUser(userId)
        );
    }


}
