package com.desafioStag.desafio.repository;

import com.desafioStag.desafio.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    List<Tarefa> findByResponsavelContainingIgnoreCase(String responsavel);

    List<Tarefa> findByDataEntrega(LocalDate dataEntrega);

    List<Tarefa> findByConcluidaFalse();

    List<Tarefa> findByConcluidaFalseAndResponsavelContainingIgnoreCase(String responsavel);
}
