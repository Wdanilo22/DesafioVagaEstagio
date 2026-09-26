package com.desafioStag.desafio.controller;

import com.desafioStag.desafio.dto.TarefaDto;
import com.desafioStag.desafio.model.Tarefa;
import com.desafioStag.desafio.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/desafio")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping("/tarefa")
    public ResponseEntity<TarefaDto> cadastroTarefa(@Valid @RequestBody TarefaDto dto){
        dto = tarefaService.cadastroTarefa(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
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
