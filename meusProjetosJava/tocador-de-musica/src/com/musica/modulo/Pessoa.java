package com.musica.modulo;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private Integer idade;
    private String email;
    private LocalDate dataNascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
