package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Erro {
    Integer status;
    String mensagem;
}
