package com.josh.tracker.service;

import com.josh.tracker.DTO.ExpenseRequestDTO;
import com.josh.tracker.DTO.ExpenseResponseDTO;
import com.josh.tracker.models.Account;
import com.josh.tracker.models.Expense;
import com.josh.tracker.repository.AccountRepo;
import com.josh.tracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImp_1 {
    @Autowired
    private ExpenseRepo expenseRepository;
    private AccountRepo userRepository;

    public ExpenseResponseDTO addExpense(ExpenseRequestDTO dto, Long userId){

        Account user = userRepository.findById(userId).orElseThrow();

        Expense expense = new Expense();

        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        expense.setAccount(user);

        expenseRepository.save(expense);

        return mapToDTO(expense);
    }

    public List<ExpenseResponseDTO> getExpensesByUser(Long userId){
        Account user = userRepository.findById(userId).orElseThrow();

        List<Expense> response = user.getExpenses();


        return List<user.getExpenses()>;
    }

}
