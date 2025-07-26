package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Erro {
    Integer status;
    String mensagem;
}
