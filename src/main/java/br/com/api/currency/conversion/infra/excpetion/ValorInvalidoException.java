package br.com.api.currency.conversion.infra.excpetion;

public class ValorInvalidoException extends RuntimeException {

    public ValorInvalidoException(String message) {
        super(message);
    }
}
