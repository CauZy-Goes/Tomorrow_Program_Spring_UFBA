package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);
}
