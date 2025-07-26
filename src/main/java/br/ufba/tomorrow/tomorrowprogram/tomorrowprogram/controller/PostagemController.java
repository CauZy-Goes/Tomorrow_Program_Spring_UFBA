package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.controller;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Postagem;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service.PostagemService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postagem")
@RequiredArgsConstructor
public class PostagemController {

    private final PostagemService postagemService;

    @GetMapping("/usuario/{id}")
    public List<Postagem> findByUsuario(@PathVariable @NotNull Long id){
        List<Postagem> postagens = postagemService.findByUsuario(id);
        return postagens;
    }

    @GetMapping
    public List<Postagem> findAll(){
        List<Postagem> postagens = postagemService.findAll();
        return postagens;
    }

}
