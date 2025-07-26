package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.controller.util;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Erro;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.ErroCampo;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<Erro> trataErroDeTipoDeArgumento(MethodArgumentTypeMismatchException e){
        Erro erro = new Erro(400, e.getMessage(), null);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler()
    public ResponseEntity<Erro> notFound(NotFoundException e){
        Erro erro = new Erro(404, e.getMessage(),null);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> erroValidacao(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> erroCampos = fieldErrors
                .stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .toList();
        Erro erro = new Erro(400, "Erro na validação dos campo" , erroCampos);
        return ResponseEntity.badRequest().body(erro);
    }
}
