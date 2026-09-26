package com.desafioStag.desafio.service;

import com.desafioStag.desafio.dto.TarefaDto;
import com.desafioStag.desafio.model.Tarefa;
import com.desafioStag.desafio.repository.TarefaRepository;
import com.desafioStag.desafio.service.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaDto cadastroTarefa(TarefaDto dto){
        Tarefa entity = new Tarefa(dto);
        entity = tarefaRepository.save(entity);
        return new TarefaDto(entity);
    }

    public List<Tarefa> listaTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas;
    }

    public TarefaDto fndById(UUID id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Produto não encontrado"));
        return new TarefaDto(tarefa);
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
