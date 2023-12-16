package br.com.api.currency.conversion.controller;

import br.com.api.currency.conversion.model.Moeda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange")
public class ConversionController {

    @PostMapping("/{amount}/{from}/{to}/{rate}")
    public ResponseEntity Conversao(@PathVariable int amount, String from, String to, BigDecimal rate) {
        return ResponseEntity.ok().build();
    }
}
