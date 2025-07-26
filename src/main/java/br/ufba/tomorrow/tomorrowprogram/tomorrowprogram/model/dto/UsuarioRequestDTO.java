package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotNull
        @NotBlank
        @Size(min = 3)
        String nome,
        @NotNull
        @Email
        @NotBlank
        String email
) {}
