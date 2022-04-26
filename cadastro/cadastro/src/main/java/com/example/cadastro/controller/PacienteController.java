package com.example.cadastro.controller;

import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;
import com.example.cadastro.repository.PacienteRepository;
import com.example.cadastro.repository.TelefoneRepository;
import com.example.cadastro.service.PacienteService;
import com.example.cadastro.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    PacienteRepository pacienteRepository;



    @PostMapping("/salvarPaciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody Paciente paciente){

        return pacienteService.salvar(paciente);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable String id){

        if(!pacienteRepository.existsById(id)){
            throw new RuntimeException("Paciente não encontrado");
        }

        pacienteService.deletar(id);
    }

    @GetMapping(path = "/{id}")
    public Paciente obterPorCodigo(@PathVariable String id){

        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }

        Paciente paciente = pacienteService.obterPorId(id);

        return paciente;
    }

    @GetMapping
    public List<Paciente> obterTodos(){

        List<Paciente> lista = pacienteService.obterTodos();

        return lista;
    }

    @PutMapping(path = "{id}")
    public Paciente atualizar(@PathVariable String id, @RequestBody Paciente paciente){

        paciente.setCodigo(id);
        paciente = pacienteService.atualizar(paciente);

        return paciente;
    }
}
