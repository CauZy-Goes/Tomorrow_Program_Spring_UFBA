package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String texto;

    @JsonIgnore
    @ManyToOne()
    Usuario usuario;

}
