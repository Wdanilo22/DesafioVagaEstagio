package com.desafioStag.desafio.service;

import com.desafioStag.desafio.model.Tarefa;
import com.desafioStag.desafio.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa cadastroTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listaTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas;
    }

    public List<Tarefa> listaTarefasResponsavel(String responsavel){
        List<Tarefa> tarefasPorResponsavel = tarefaRepository.findByResponsavelContainingIgnoreCase(responsavel);
        return tarefasPorResponsavel;
    }

    public List<Tarefa> listaTarefasDataEntrega(LocalDate dataEntrega){
        List<Tarefa> tarefasPorDataEntrega = tarefaRepository.findByDataEntrega(dataEntrega);
        return tarefasPorDataEntrega;
    }

    public List<Tarefa> listaTarefasPendentes(){
        List<Tarefa> tarefasPendentes = tarefaRepository.findByConcluidaFalse();
        return tarefasPendentes;
    }

    public List<Tarefa> listaTarefaPendentesPorResponsavel(String responsavel){
        List<Tarefa> tarefasPendentesPorResponsavel = tarefaRepository.findByConcluidaFalseAndResponsavelContainingIgnoreCase(responsavel);
        return tarefasPendentesPorResponsavel;
    }

}
