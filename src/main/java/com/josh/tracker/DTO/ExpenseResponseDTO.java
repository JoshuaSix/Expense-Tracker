package com.josh.tracker.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseResponseDTO {
    private Long id;

    private Double amount;

    private String description;

    private String category;

    private LocalDate date;
}