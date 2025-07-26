package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
}
