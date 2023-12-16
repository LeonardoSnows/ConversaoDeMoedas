package br.com.api.currency.conversion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Moeda {
    private int amount;

    private String from;

    private String to;

    private BigDecimal rate;
}
