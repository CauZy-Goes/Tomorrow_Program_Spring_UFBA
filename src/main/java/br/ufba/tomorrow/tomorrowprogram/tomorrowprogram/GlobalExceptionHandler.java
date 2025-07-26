package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<Erro> trataErroDeTipoDeArgumento(MethodArgumentTypeMismatchException e){
        Erro erro = new Erro(400, e.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler()
    public ResponseEntity<Erro> notFound(NotFoundException e){
        Erro erro = new Erro(404, e.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }

}
