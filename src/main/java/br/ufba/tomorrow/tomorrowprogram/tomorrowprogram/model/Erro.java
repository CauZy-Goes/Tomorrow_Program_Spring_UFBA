package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;


public record Erro(
    Integer status,
    String mensagem,
    List<ErroCampo> erroCampo){}
