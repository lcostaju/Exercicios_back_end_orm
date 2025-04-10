package br.edu.iftm.pbackorm.sistema_contatos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.pbackorm.sistema_contatos.domain.Contato;
import br.edu.iftm.pbackorm.sistema_contatos.dto.ErroDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/contatos")
public class ContatosController {

    private List<Contato> contatos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Contato>> buscar() {
        return ResponseEntity
                .ok(contatos);
    }

    @PostMapping()
    public ResponseEntity<?> salvar(@RequestBody Contato novoContato) {
        if (novoContato.getNome() == null || novoContato.getNome().equals("")) {
            return ResponseEntity.badRequest().body(new ErroDTO("Não recebi o nome", LocalDateTime.now()));
        }
        if (contatos.contains(novoContato)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErroDTO("Codigo ja existe " + novoContato.getCodigo(), LocalDateTime.now()));
        }
        contatos.add(novoContato);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoContato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Contato attContato) {
        //TODO: process PUT request
        
        for (Contato contato : contatos) {
            if(contato.getCodigo().equals(attContato.getCodigo())){
                contato.setNome(attContato.getNome());

                return ResponseEntity.ok(contato);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroDTO("Não encontrado", LocalDateTime.now()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        boolean removido  = contatos.removeIf(contato -> contato.getCodigo().equals(id));

        if (removido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroDTO("Contato não encontrado", LocalDateTime.now()));
    }

}
