package com.example.cadastro.repository;


import com.example.cadastro.model.Paciente;
import com.example.cadastro.model.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {


}