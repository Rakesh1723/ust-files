package com.myportfolio.portfolioms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MutualFunds {
    private int id;
    private String fundName;
    private double amountInvested;
    private double growthRate;
}
