package br.edu.iftm.tspi.pbackorm.hello_world.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.pbackorm.hello_world.domain.Contato;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWordController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Oi amigos";
    }

    @GetMapping("/contato")
    public List<Contato> getContatos() {
        return Arrays.asList(new Contato(1, "Goku"), 
        new Contato(2, "Vegeta"));
    }
    
}
