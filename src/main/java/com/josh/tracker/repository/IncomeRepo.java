package com.josh.tracker.repository;

import com.josh.tracker.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long> {
    List<Income> findByUserId(Long userId);
}
