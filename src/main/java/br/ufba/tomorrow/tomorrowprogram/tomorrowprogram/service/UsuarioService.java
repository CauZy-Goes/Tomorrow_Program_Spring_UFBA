package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.Model.Usuario;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private List<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario("caua", "Caua@gmail.com"),
            new Usuario("Pam", "Pam@gmail.com"),
            new Usuario("brian", "brian@gmail.com")
    ));

    public Optional<Usuario> findById(Integer id){
        if(!existeUsuario(id))
            return null;

        return Optional.ofNullable(usuarios.get(id));
    }

    public Boolean removeById(Integer id){
        if(!existeUsuario(id))
            return false;
        int teste = id;

        usuarios.remove(teste);

        return  true;
    }

    public Usuario updateUsuario(Integer id, Usuario usuarioModificado){
        if (!existeUsuario(id))
            return null;

        Usuario usuario = usuarios.get(id);

        String nome = usuarioModificado.getNome();
        String email = usuarioModificado.getEmail();

        usuario.setNome(usuarioModificado.getNome());
        usuario.setEmail(usuarioModificado.getEmail());

        return usuario;
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

    private boolean existeUsuario(Integer indice) {
        return indice != null && indice >= 0 && indice < usuarios.size();
    }
}
