package br.edu.iftm.pbackorm.sistema_contatos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contato {
    private Integer codigo;

    private String nome;
}
