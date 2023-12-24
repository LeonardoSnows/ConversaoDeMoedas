package br.com.api.currency.conversion.dto.response;

import java.math.BigDecimal;

public record ValuesDeConversao(BigDecimal valorConvertido, String simboloMoeda) {
}
