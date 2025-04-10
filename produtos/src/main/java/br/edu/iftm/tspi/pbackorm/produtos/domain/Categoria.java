package br.edu.iftm.tspi.pbackorm.produtos.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Categoria {
    private Integer codigo;
    private String nome;
    private List<Produto> produtos;
}
