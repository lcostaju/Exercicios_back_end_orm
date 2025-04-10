package br.edu.iftm.tspi.pbackorm.produtos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Produto {
    private Integer codigo;
    private String nome;
    private Categoria categoria;
}
