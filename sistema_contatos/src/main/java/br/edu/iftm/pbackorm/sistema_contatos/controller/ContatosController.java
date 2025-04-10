package br.edu.iftm.pbackorm.sistema_contatos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.pbackorm.sistema_contatos.domain.Contato;
import br.edu.iftm.pbackorm.sistema_contatos.dto.ErroDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contatos")
public class ContatosController {
    
    private List<Contato> contatos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Contato>> buscar(){
        return ResponseEntity
        .ok(contatos);
    }

    @PostMapping()
    public ResponseEntity<?> salvar(@RequestBody Contato novoContato) {
        if(novoContato.getNome() == null || novoContato.getNome().equals("")){
            return ResponseEntity.badRequest().body(new ErroDTO("Não recebi o nome",LocalDateTime.now()));
        }
        contatos.add(novoContato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
    }
    
}
