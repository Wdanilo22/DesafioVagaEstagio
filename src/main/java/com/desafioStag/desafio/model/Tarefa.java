package com.desafioStag.desafio.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tarefa_tb")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String descricao;
    private String responsavel;
    private LocalDate dataEntrega;
    private Boolean concluida = false;

    public Tarefa(UUID id, String titulo, String descricao, String responsavel, LocalDate dataEntrega) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataEntrega = dataEntrega;
    }

    public Tarefa(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
