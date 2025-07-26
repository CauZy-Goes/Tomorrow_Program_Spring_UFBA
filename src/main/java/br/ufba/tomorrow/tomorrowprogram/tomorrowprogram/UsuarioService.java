package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

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
        return Collections.unmodifiableList(usuarios);
    }

    public boolean saveUsuario(Usuario usuario){

        if (usuario.getEmail() == null || usuario.getNome() == null){
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    private boolean existeUsuario(Integer indice) {
        return indice != null && indice >= 0 && indice < usuarios.size();
    }
}
