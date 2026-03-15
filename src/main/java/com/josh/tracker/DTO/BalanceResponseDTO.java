package com.josh.tracker.DTO;

import lombok.Data;

@Data
public class BalanceResponseDTO {

    private Double totalIncome;

    private Double totalExpenses;

    private Double remainingBalance;
}
