package com.josh.tracker.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeRequestDTO {

    private Double amount;

    private String source;

    private LocalDate date;

    private String description;
}
