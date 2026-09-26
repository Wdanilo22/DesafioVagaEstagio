package com.desafioStag.desafio.dto;

import com.desafioStag.desafio.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public class TarefaDto {

    private UUID id;

    @Size(min = 3,max = 80, message = "Titulo precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String titulo;

    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    @NotBlank(message = "Campo obrigatório")
    private String responsavel;

    private LocalDate dataEntrega;
    private Boolean concluida = false;

    public TarefaDto(){}

    public TarefaDto(UUID id, String titulo, String descricao, String responsavel, LocalDate dataEntrega) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataEntrega = dataEntrega;
    }

    public TarefaDto(Tarefa tarefa){
        id = tarefa.getId();
        titulo = tarefa.getTitulo();
        descricao = tarefa.getDescricao();
        responsavel = tarefa.getResponsavel();
        dataEntrega = tarefa.getDataEntrega();
        concluida = tarefa.getConcluida();
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Boolean getConcluida() {
        return concluida;
    }
}
