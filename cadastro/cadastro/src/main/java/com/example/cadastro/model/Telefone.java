package com.example.cadastro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telefones")
public class Telefone {

    @Id
    //@Column(name = "id")
    private String codigo;

    //@Column(name = "tel")
    private String telefone;

    public Telefone() {
    }

    public Telefone(String codigo, String telefone) {
        this.codigo = codigo;
        this.telefone = telefone;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
