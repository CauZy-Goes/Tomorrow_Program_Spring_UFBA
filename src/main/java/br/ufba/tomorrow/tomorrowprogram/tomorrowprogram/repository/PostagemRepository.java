package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostagemRepository extends JpaRepository<Postagem,Long> {

    public List<Postagem> findByUsuarioId(Long id);
}
