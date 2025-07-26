package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.model;

import jakarta.persistence.*;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String texto;

    @ManyToOne()
    Usuario usuario;

}
