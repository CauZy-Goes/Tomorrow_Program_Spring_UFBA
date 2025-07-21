package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario("caua", "Caua@gmail.com"),
            new Usuario("Pam", "Pam@gmail.com"),
            new Usuario("brian", "brian@gmail.com")
    ));

    public Usuario findById(Integer id){
        if(!existeUsuario(id))
            return null;

        return  usuarios.get(id);
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

    public List<Usuario> findAll(){
        return usuarios;
    }

    public boolean saveUsuario(Usuario usuario){

        usuarios.add(usuario);
        return true;
    }

    private boolean existeUsuario(Integer indice) {
        return indice != null && indice >= 0 && indice < usuarios.size();
    }
}
