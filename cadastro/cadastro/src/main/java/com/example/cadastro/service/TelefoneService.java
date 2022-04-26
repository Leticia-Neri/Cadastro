package com.example.cadastro.service;

import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;

import java.util.List;

public interface TelefoneService {

    Telefone salvar(Telefone telefone);

    void deletar(String id);

    Telefone atualizar(Telefone telefone);

    Telefone obterPorId(String id);

    List<Telefone> obterTodos();
}
