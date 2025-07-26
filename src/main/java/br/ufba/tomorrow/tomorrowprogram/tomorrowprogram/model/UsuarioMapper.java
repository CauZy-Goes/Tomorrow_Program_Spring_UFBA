package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.dto.UsuarioRequestDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioRequestDTO toDTO(Usuario usuario);

    Usuario toEntity(UsuarioRequestDTO usuarioDTO);
}
