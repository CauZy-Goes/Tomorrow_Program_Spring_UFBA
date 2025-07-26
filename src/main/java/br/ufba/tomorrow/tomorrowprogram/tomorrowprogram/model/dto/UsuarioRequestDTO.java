package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotNull
        @Size(min = 3)
        String nome,
        @NotNull
        @Email
        String email
) {}
