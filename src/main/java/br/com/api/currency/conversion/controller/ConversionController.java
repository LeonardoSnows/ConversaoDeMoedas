package br.com.api.currency.conversion.controller;

import br.com.api.currency.conversion.dto.response.ValuesDeConversao;
import br.com.api.currency.conversion.model.Moeda;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange")
@Validated
public class ConversionController {

    @PostMapping("/{amount}/{from}/{to}/{rate}")
    public ResponseEntity Conversao(@PathVariable String amount,
                                    @PathVariable @Size(min = 3, max = 3) String from,
                                    @PathVariable @Size(min = 3, max = 3) String to,
                                    @PathVariable String rate) {


        BigDecimal valorRate = Moeda.formataValores(rate);
        BigDecimal valorAmount = Moeda.formataValores(amount);

        Moeda moeda = new Moeda(valorAmount, from, to, valorRate);

        BigDecimal valorConvertido = moeda.ConverterParaMoedaEscolhida();

        return ResponseEntity.ok(new ValuesDeConversao(valorConvertido, moeda.getSimboloMoeda()));

    }
}
