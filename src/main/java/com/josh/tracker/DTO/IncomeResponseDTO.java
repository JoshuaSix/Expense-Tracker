package com.josh.tracker.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeResponseDTO {

    private Long id;

    private Double amount;

    private String source;

    private LocalDate date;

    private String description;
}
