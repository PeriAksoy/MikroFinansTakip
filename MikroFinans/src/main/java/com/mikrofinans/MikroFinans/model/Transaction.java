package com.mikrofinans.MikroFinans.model;

import com.mikrofinans.MikroFinans.model.request.TransactionsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //user_id user nesnesinden referans alıyor
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //category_id category nesnesinden referans alıyor
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull(message = "Tutar boş olamaz")
    private Double amount;

    private String description;

    private LocalDate date;

    @Column(name = "is_income")
    private Boolean isIncome = false;

}
