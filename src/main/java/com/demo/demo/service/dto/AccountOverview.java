package com.demo.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountOverview implements Serializable {
    private List<Account> accounts;
    private List<Credit> credits;
    private List<Cdt> cdts;
    private BigDecimal accountsAvailableBalance;
    private BigDecimal accountsTotalBalance;
    private BigDecimal creditsBalance;
    private BigDecimal usedQuotasBalance;
    private BigDecimal cdtsBalance;
    private BigDecimal totalCurrency;
    private boolean origenPaid;
}
