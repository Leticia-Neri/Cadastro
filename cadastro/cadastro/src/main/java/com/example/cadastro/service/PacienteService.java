package com.example.cadastro.service;

import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;

import java.util.List;

public interface PacienteService {

    Paciente salvar(Paciente paciente);

    void deletar(String id);

    Paciente atualizar(Paciente paciente);

    Paciente obterPorId(String id);

    List<Paciente> obterTodos();
}
