package br.edu.iftm.pbackorm.sistema_contatos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErroDTO {
    private String mensagem;
    private LocalDateTime data;
}
