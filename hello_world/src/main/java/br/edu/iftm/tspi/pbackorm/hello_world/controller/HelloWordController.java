package br.edu.iftm.tspi.pbackorm.hello_world.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.pbackorm.hello_world.domain.Contato;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/contatos")
public class HelloWordController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Oi amigos";
    }
    // @GetMapping
    // public List<Contato> getContatos() {
    //     return Arrays.asList(new Contato(1, "Goku"), 
    //     new Contato(2, "Vegeta"));
    // }

    @GetMapping
    public ResponseEntity<List<Contato>> getContatos() {
    List<Contato> contatos = Arrays.asList(new Contato(1, "Goku"), 
        new Contato(2, "Vegeta"));

        return ResponseEntity.ok().body(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Contato>> buscaPorId(@PathVariable Integer id) {

        List<Contato> contatos = Arrays.asList(new Contato(1, "Goku"), 
        new Contato(2, "Vegeta"));

        for (Contato contato : contatos) {
            if (contato.getCodigo().equals(id)) {
                return ResponseEntity.ok().body(Arrays.asList(contato));
            }
        }
        return ResponseEntity.notFound().build();
    }
    
}
