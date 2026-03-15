package com.josh.tracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String source; // Salary, Business, Gift, etc.

    private LocalDate date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "Account_id")
    private Account account;

}
