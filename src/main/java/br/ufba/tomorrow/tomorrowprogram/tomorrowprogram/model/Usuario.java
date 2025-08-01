package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@NoArgsConstructor              // Necessário para o JPA
@AllArgsConstructor            // Cria construtor com todos os campos, incluindo o id
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "id")
    List<Postagem> postagens;

    // ✅ Construtor personalizado sem o id
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
