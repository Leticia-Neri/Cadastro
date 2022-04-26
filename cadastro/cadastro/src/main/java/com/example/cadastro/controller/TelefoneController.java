package com.example.cadastro.controller;


import com.example.cadastro.model.Telefone;
import com.example.cadastro.repository.TelefoneRepository;
import com.example.cadastro.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("telefones")
public class TelefoneController {

    @Autowired
    TelefoneService telefoneService;

    @Autowired
    TelefoneRepository telefoneRepository;



    @PostMapping("/salvarTelefone")
    @ResponseStatus(HttpStatus.CREATED)
    public Telefone salvar(@RequestBody Telefone telefone){
        return telefoneService.salvar(telefone);
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable String id){

        if(!telefoneRepository.existsById(id)){
            throw new RuntimeException("Telefone não encontrado");
        }

        telefoneService.deletar(id);
    }

    @GetMapping(path = "/{id}")
    public Telefone obterPorCodigo(@PathVariable String id){

        if (!telefoneRepository.existsById(id)) {
            throw new RuntimeException("Telefone não encontrado");
        }

        Telefone telefone = telefoneService.obterPorId(id);

        return telefone;
    }

    @GetMapping
    public List<Telefone> obterTodos(){

        List<Telefone> lista = telefoneService.obterTodos();

        return lista;
    }

    @PutMapping(path = "{id}")
    public Telefone atualizar(@PathVariable String id, @RequestBody Telefone telefone){

        telefone.setCodigo(id);
        telefone = telefoneService.atualizar(telefone);

        return telefone;
    }
}
