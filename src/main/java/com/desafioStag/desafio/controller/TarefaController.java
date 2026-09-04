package com.desafioStag.desafio.controller;

import com.desafioStag.desafio.model.Tarefa;
import com.desafioStag.desafio.service.TarefaService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/desafio")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping("/tarefa")
    public ResponseEntity<Tarefa> cadastroTarefa(@RequestBody Tarefa tarefa){
        tarefaService.cadastroTarefa(tarefa);
        return ResponseEntity.ok().body(tarefa);
    }

    @GetMapping("/tarefas")
    public ResponseEntity<List<Tarefa>> listaTarefas(){
        List<Tarefa> tarefas = tarefaService.listaTarefas();
        return ResponseEntity.ok().body(tarefas);
    }

    @GetMapping("/tarefas/responsavel")
    public ResponseEntity<List<Tarefa>> listaTarefasPorResponsavel(@RequestParam String responsavel){
        List<Tarefa> tarefasPorResponsavel = tarefaService.listaTarefasResponsavel(responsavel);
        return ResponseEntity.ok().body(tarefasPorResponsavel);
    }

    @GetMapping("/tarefas/data")
    public ResponseEntity<List<Tarefa>> listaTarefasPorDataEntrega(@RequestParam LocalDate data){
        List<Tarefa> tarefasPorDataDeEntrega = tarefaService.listaTarefasDataEntrega(data);
        return ResponseEntity.ok().body(tarefasPorDataDeEntrega);
    }

    @GetMapping("/tarefas/pendentes")
    public ResponseEntity<List<Tarefa>> listaTarefasPendentes(@RequestParam(required = false) String responsavel){
        if(responsavel != null){
            List<Tarefa> tarefasPendentesPorResponsavel = tarefaService.listaTarefaPendentesPorResponsavel(responsavel);
            return ResponseEntity.ok().body(tarefasPendentesPorResponsavel);
        }else{
            List<Tarefa> tarefaPendentes = tarefaService.listaTarefasPendentes();
            return ResponseEntity.ok().body(tarefaPendentes);
        }
    }
}
