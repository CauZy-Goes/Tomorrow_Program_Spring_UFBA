package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>(List.of(
            new Usuario("caua","Caua@gmail.com"),
            new Usuario("Pam","Pam@gmail.com"),
            new Usuario("brian","brian@gmail.com")
    ));


    // O Spring Boot utiliza a biblioteca Jackson para serializar automaticamente os objetos Java em JSON.
// Neste caso, ao retornar uma lista de objetos Usuario, o Jackson converte cada instância da classe Usuario
// em uma estrutura JSON correspondente. Isso acontece porque o Spring Boot, ao detectar que o retorno
// do controller é um objeto e não uma view (como em aplicações MVC tradicionais),
// utiliza um mecanismo de Content Negotiation e converte automaticamente o retorno para o formato apropriado,
// geralmente JSON, que é o padrão para APIs REST.
//
// Exemplo da conversão:
// Um objeto Usuario { id: 1, nome: "Cauã" } é transformado em:
// { "id": 1, "nome": "Cauã" }
//
// Essa conversão é feita com base nos getters da classe Usuario. Se quiser personalizar a forma como
// os campos são serializados, você pode usar anotações do Jackson como @JsonProperty, @JsonIgnore, etc.
//
// JACKSON (Serialização JSON automática)
    @GetMapping()
    @Operation(summary = "Lista todos os usuários")
    public List<Usuario> getAllUsuarios(){
        return usuarios;
    }

    @GetMapping("/{indice}")
    public ResponseEntity<?> getUsuario(@PathVariable int indice){

        try {
            Usuario usuario = usuarios.get(indice);
            return ResponseEntity.ok(usuario);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado no índice informado.");
        }
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
        String nome = usuario.getNome();
        String email = usuario.getEmail();

        if(nome == null || email == null)
            return ResponseEntity.status(400).body("Existem campos nulos");

        usuarios.add(new Usuario(usuario.getNome(), usuario.getEmail()));

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer indice, @RequestBody Usuario usuarioModificado){
        try {

            Usuario usuario = usuarios.get(indice);

            String nome = usuarioModificado.getNome();
            String email = usuarioModificado.getEmail();

            if(nome == null || email == null)
                return ResponseEntity.status(400).body("Existem campos nulos");

            usuario.setNome(usuarioModificado.getNome());
            usuario.setEmail(usuario.getEmail());

            return ResponseEntity.status(200).body(usuario);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado no índice informado.");
        }
    }

}
