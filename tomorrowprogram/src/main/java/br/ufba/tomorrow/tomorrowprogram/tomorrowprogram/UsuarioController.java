package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios/")
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
    public List<Usuario> getAllUsuarios(){
        return usuarios;
    }
}
