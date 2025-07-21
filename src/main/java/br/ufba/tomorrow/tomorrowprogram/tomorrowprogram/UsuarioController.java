package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;

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
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{indice}")
    public ResponseEntity<?> getUsuario(@PathVariable int indice) {

        Usuario usuario = usuarioService.findById(indice);

        if(usuario == null)
            return ResponseEntity.status(404).body("Usuário Não encontrado");

        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
       if(!usuarioService.saveUsuario(usuario))
           return ResponseEntity.status(400).body("Não foi possivel criar");
       return ResponseEntity.ok().build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer indice, @RequestBody Usuario usuarioModificado) {

        Usuario usuario = usuarioService.updateUsuario(indice, usuarioModificado);

        if(usuario == null)
            return ResponseEntity.status(404).body("Usuário Não encontrado");

        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity removeUsuario(@PathVariable int indice) {

        if(!usuarioService.removeById(indice)){
            return ResponseEntity.status(404).body("Usuário Não encontrado");
        }

        return ResponseEntity.status(204).build();

    }
}
