package com.josh.tracker.repository;

import com.josh.tracker.models.Account;
import com.josh.tracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
