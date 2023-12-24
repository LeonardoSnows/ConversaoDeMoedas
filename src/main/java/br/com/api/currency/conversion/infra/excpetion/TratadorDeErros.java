package br.com.api.currency.conversion.infra.excpetion;

import br.com.api.currency.conversion.dto.response.HandleOfPositiveValueAndFormatNumber;
import br.com.api.currency.conversion.dto.response.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseException> handleNotFoundException(NoHandlerFoundException ex) {
        return new ResponseEntity<ResponseException>(new ResponseException("Verifique as informações passadas como parâmetro, pois o recurso solicitado não existe"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<HandleOfPositiveValueAndFormatNumber> handleInternalServerError(Exception ex) {
        String mensagemErro = ex.getMessage();
        String modeloUrl = "/exchange/1.9(valores divididos por '.')/BRL(maximos 3 caracteres)/USD(maximos 3 caracteres)/1.4(valores divididos por '.')";

        HandleOfPositiveValueAndFormatNumber handleOfPositiveValueAndFormatNumber = new HandleOfPositiveValueAndFormatNumber(mensagemErro, modeloUrl);
        return new ResponseEntity<>(handleOfPositiveValueAndFormatNumber, HttpStatus.BAD_REQUEST);
    }
}
