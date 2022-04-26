package com.example.cadastro.service;

import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;
import com.example.cadastro.repository.PacienteRepository;
import com.example.cadastro.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletar(String id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        Optional<Paciente> pacienteId = pacienteRepository.findById(paciente.getCodigo());

        if(!pacienteId.isPresent()){
            throw new RuntimeException("Paciente não encontrado");
        }
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obterPorId(String id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public List<Paciente> obterTodos() {
        return pacienteRepository.findAll();
    }
}
