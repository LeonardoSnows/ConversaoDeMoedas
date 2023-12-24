package br.com.api.currency.conversion.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HandleOfPositiveValueAndFormatNumber(
        @JsonProperty("Mensagem de Erro")
        String message,

        @JsonProperty("Url permitida")
        String urlPermitida

        ) {

}
