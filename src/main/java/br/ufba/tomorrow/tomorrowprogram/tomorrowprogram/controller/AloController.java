package br.ufba.tomorrow.tomorrowprogram.tomorrowprogram.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/ola")
public class AloController {
    @GetMapping()
    public String alo() {
        return "Alô, mundo!";
    }

    @GetMapping("/dizer/{quem}")
    public String ola(@PathVariable  String quem){
        return "Ola, " + quem;
    }
}

