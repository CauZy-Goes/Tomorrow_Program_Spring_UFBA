package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Usuario;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository.UsuarioRepository;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public void removeById(Long id){
        usuarioRepository.delete(findById(id));
    }

    public Usuario updateUsuario(Long id, Usuario usuarioModificado){

        if(!usuarioRepository.existsById(id))
            throw new NotFoundException("Usuário não encontrado");

        usuarioModificado.setId(id);

        return usuarioRepository.save(usuarioModificado);
    }

//    🧠 Por que usar Collections.unmodifiableList()?
//    Esse padrão é usado para proteger a lista original contra modificações acidentais ou mal-intencionadas por parte de quem usa a API.
//    Por exemplo, se você retornasse diretamente return usuarios, alguém poderia fazer :
//    usuarioService.findAll().clear(); // Isso apagaria todos os usuários!
//    Mas ao usar unmodifiableList(), isso geraria uma exceção UnsupportedOperationException, impedindo alterações externas.
    public List<Usuario> findAll(){
        return Collections.unmodifiableList(usuarioRepository.findAll());
    }

    public void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Email não encontrado"));
    }
}
