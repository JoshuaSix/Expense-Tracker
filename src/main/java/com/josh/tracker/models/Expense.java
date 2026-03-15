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
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
