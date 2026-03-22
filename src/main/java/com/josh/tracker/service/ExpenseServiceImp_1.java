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
public class ExpenseServiceImp_1 implements ExpenseService {
    @Autowired
    private AccountRepo userRepository;
    @Autowired
    private ExpenseRepo expenseRepository;

    private ExpenseResponseDTO mapToExpenseDTO(Expense expense){

        ExpenseResponseDTO dto = new ExpenseResponseDTO();

        dto.setId(expense.getId());
        dto.setAmount(expense.getAmount());
        dto.setDescription(expense.getDescription());
        dto.setDate(expense.getDate());

        if(expense.getCategory() != null){
            dto.setCategory(expense.getCategory().getName());
        }

        return dto;
    }

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO dto, Long userId){

        Account user = userRepository.findById(userId).orElseThrow();

        Expense expense = new Expense();

        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        expense.setAccount(user);

        expenseRepository.save(expense);

        return mapToExpenseDTO(expense);
    }

    @Override
    public List<ExpenseResponseDTO> getExpensesByUser(Long userId){
        Account user = userRepository.findById(userId).orElseThrow();
        List<Expense> ExpenseList = expenseRepository.findByUserId(user.getId());

        return ExpenseList.stream()
                .map(this::mapToExpenseDTO)
                .toList();

    }


    @Override
    public ExpenseResponseDTO getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id).orElseThrow();

        return mapToExpenseDTO(expense);
    }

    @Override
    public String deleteExpense(Long id){
       expenseRepository.findById(id).orElseThrow();

       return "Expense deleted successfully!";

    }


}
