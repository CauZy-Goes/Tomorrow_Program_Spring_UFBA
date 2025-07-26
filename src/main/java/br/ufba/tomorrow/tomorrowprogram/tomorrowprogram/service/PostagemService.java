package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Postagem;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository.PostagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostagemService {

    private final PostagemRepository postagemRepository;

    public List<Postagem> findByUsuario(Long id){
        return postagemRepository.findByUsuarioId(id);
    }

    public List<Postagem> findAll(){
        return postagemRepository.findAll();
    }
}
