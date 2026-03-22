package com.josh.tracker.service;

import com.josh.tracker.DTO.IncomeRequestDTO;
import com.josh.tracker.DTO.IncomeResponseDTO;

import java.util.List;

public interface IncomeService {
    IncomeResponseDTO addIncome(IncomeRequestDTO dto, Long userId);

    List<IncomeResponseDTO> getUserIncome(Long userId);

    IncomeResponseDTO getIncomeById(Long id);

    void deleteIncome(Long id);
}
