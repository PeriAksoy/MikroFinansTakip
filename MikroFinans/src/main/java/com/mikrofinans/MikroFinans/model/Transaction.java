package com.mikrofinans.MikroFinans.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @NotNull(message = "Tutar boş olamaz")
    private Double amount;

    private String description;

    private LocalDate date;

    @Column(name = "is_income")
    private Boolean isIncome = false;
    @Column(name = "gelir_mi")
    private Boolean gelirMi = false;

}
