package com.mikrofinans.MikroFinans.model.request;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionsDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Category ID cannot be null")
    private Long categoryId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    private String description;

    private LocalDate date;

    private Boolean isIncome = false;
}
