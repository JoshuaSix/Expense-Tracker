package com.josh.tracker.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequestDTO {
    private Double amount;

    private String description;

    private LocalDate date;

    private Long categoryId;
}
