package com.example.cadastro.service;

import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;
import com.example.cadastro.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneServiceImpl implements TelefoneService{

    @Autowired
    TelefoneRepository telefoneRepository;

    @Override
    public Telefone salvar(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    @Override
    public void deletar(String id) {
        telefoneRepository.deleteById(id);
    }

    @Override
    public Telefone atualizar(Telefone telefone) {
        Optional<Telefone> pacienteId = telefoneRepository.findById(telefone.getCodigo());
        if(pacienteId.isPresent()){
            throw new RuntimeException("Telefone não encontrado");
        }
        return telefoneRepository.save(telefone);
    }

    @Override
    public Telefone obterPorId(String id) {
        return telefoneRepository.findById(id).get();
    }

    @Override
    public List<Telefone> obterTodos() {
        return telefoneRepository.findAll();
    }
}
