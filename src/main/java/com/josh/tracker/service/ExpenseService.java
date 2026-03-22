package com.josh.tracker.service;

import com.josh.tracker.DTO.ExpenseRequestDTO;
import com.josh.tracker.DTO.ExpenseResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExpenseService {
    ExpenseResponseDTO addExpense(ExpenseRequestDTO dto, Long userId);

    List<ExpenseResponseDTO> getExpensesByUser(Long userId);

    ExpenseResponseDTO getExpenseById(Long id);

    String deleteExpense(Long id);
}
