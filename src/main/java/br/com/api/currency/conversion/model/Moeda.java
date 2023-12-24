package br.com.api.currency.conversion.model;

import br.com.api.currency.conversion.enumeration.SimboloMoeda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Moeda {

    private BigDecimal amount;
    private String from;
    private String to;
    private BigDecimal rate;
    private String simboloMoeda;

    public Moeda(BigDecimal amount, String from, String to, BigDecimal rate) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.rate = rate;
        getSymbol();
    }

    public BigDecimal ConverterParaMoedaEscolhida() {
        return rate.multiply(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void getSymbol() {
        validandoConversoes(from, to);
        switch (to) {
            case "BRL" -> this.simboloMoeda = String.valueOf(SimboloMoeda.R$);
            case "USD" -> this.simboloMoeda = String.valueOf(SimboloMoeda.$);
            case "EUR" -> this.simboloMoeda = String.valueOf(SimboloMoeda.€);
            default -> throw new RuntimeException();
        }
    }

    private void validandoConversoes(String from, String to) {
        if ((from.equals("USD") && to.equals("EUR") || (from.equals("EUR") && to.equals("USD")))) {
            throw new RuntimeException("Transacoes nao permitidas entre USD e EUR");
        }
    }

    public void validadoTiposDeMoedas(String from, String to) {
        try {
            SimboloMoeda de = SimboloMoeda.valueOf(from);
            SimboloMoeda para = SimboloMoeda.valueOf(to);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Simbolos ilegais, aceitos apenas sao: BRL, USD e EUR");
        }

    }


    public static BigDecimal formataValores(String valores) {
        String valoresConvertidos = valores.replaceAll(",", ".");

        BigDecimal valorParamentro = new BigDecimal(valoresConvertidos);

        if (valorParamentro.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Valor devem ser maiores que 0.0");
        }
        return valorParamentro;

    }
}
