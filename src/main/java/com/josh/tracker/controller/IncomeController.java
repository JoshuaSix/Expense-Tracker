package com.josh.tracker.controller;


import com.josh.tracker.DTO.IncomeRequestDTO;
import com.josh.tracker.DTO.IncomeResponseDTO;
import com.josh.tracker.service.IncomeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
@CrossOrigin
public class IncomeController {
    @Autowired
    private IncomeServiceImp incomeService;

//    public IncomeController(IncomeServiceImp incomeService) {
//        this.incomeService = incomeService;
//    }

    // Add income
    @PostMapping("/user/{userId}")
    public ResponseEntity<IncomeResponseDTO> addIncome(
            @RequestBody IncomeRequestDTO dto,
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                incomeService.addIncome(dto, userId)
        );
    }

    // Get all income for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeResponseDTO>> getUserIncome(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                incomeService.getUserIncome(userId)
        );
    }

    // Get single income
    @GetMapping("/user/{id}")
    public ResponseEntity<IncomeResponseDTO> getIncomeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                incomeService.getIncomeById(id)
        );
    }

    // Delete income
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIncome(
            @PathVariable Long id) {

        incomeService.deleteIncome(id);

        return ResponseEntity.ok("Income deleted successfully");
    }
}
