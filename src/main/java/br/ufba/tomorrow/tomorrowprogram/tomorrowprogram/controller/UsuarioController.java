package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.controller;

import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.UsuarioMapper;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.dto.UsuarioRequestDTO;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service.exception.NotFoundException;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model.Usuario;
import br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper;

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
    public ResponseEntity<Usuario> getUsuario(@PathVariable @NotNull long indice) {

        Usuario usuario = usuarioService.findById(indice);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioDTO) {
//       if(!usuarioService.saveUsuario(usuario)){
////           throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Campos estão vazios",);
//           return ResponseEntity.status(400).body("Não foi possivel criar");
//       }

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);


        usuarioService.saveUsuario(usuario);
       return ResponseEntity.ok().build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long indice, @RequestBody UsuarioRequestDTO usuarioModificadoDTO) {

        Usuario usuarioModificado = usuarioMapper.toEntity(usuarioModificadoDTO);

        Usuario usuario = usuarioService.updateUsuario(indice, usuarioModificado);

        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity removeUsuario(@PathVariable @NotNull long indice) {

        usuarioService.removeById(indice);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

}
