package com.josh.tracker.service;

import com.josh.tracker.DTO.IncomeRequestDTO;
import com.josh.tracker.DTO.IncomeResponseDTO;
import com.josh.tracker.models.Account;
import com.josh.tracker.models.Income;
import com.josh.tracker.repository.AccountRepo;
import com.josh.tracker.repository.IncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImp implements IncomeService {

    @Autowired
    private IncomeRepo incomeRepository;
    @Autowired
    private AccountRepo userRepository;

//    public IncomeServiceImpl(IncomeRepository incomeRepository,
//                             UserRepository userRepository) {
//        this.incomeRepository = incomeRepository;
//        this.userRepository = userRepository;
//    }

    @Override
    public IncomeResponseDTO addIncome(IncomeRequestDTO dto, Long userId) {

        Account user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = new Income();

        income.setAmount(dto.getAmount());
        income.setSource(dto.getSource());
        income.setDate(dto.getDate());
        income.setDescription(dto.getDescription());
        income.setAccount(user);

        incomeRepository.save(income);

        return mapToDTO(income);
    }

    @Override
    public List<IncomeResponseDTO> getUserIncome(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return incomeRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public IncomeResponseDTO getIncomeById(Long id) {

        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        return mapToDTO(income);
    }

    @Override
    public void deleteIncome(Long id) {

        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        incomeRepository.delete(income);
    }

    // MAPPER METHOD
    private IncomeResponseDTO mapToDTO(Income income) {

        IncomeResponseDTO dto = new IncomeResponseDTO();

        dto.setId(income.getId());
        dto.setAmount(income.getAmount());
        dto.setSource(income.getSource());
        dto.setDate(income.getDate());
        dto.setDescription(income.getDescription());

        return dto;
    }
}
