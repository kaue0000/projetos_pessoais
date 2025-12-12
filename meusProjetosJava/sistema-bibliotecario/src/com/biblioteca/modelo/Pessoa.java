package com.biblioteca.modelo;
import com.biblioteca.servico.validador.caracterValidador;
import java.time.LocalDate;

public abstract class Pessoa {
    public enum Genero {
        MASCULINO,
        FEMININO
    }
    //ATRIBUTOS
    private String nomeCompleto;
    private final LocalDate DATANASCIMENTO;
    private final String CPF;
    private Genero genero;

    public Pessoa(String nomeCompleto, String dataNascimento, String cpf, Genero genero) {
        setNomeCompleto(nomeCompleto);
        this.DATANASCIMENTO = LocalDate.parse(dataNascimento); 
        this.CPF = cpf;
        setGenero(genero);
    }

    public void setNomeCompleto(String nomeCompleto) {

        boolean nomeComCaracteresInvalidos = !caracterValidador.verificarCaracterInvalido(nomeCompleto);
        
        if (nomeComCaracteresInvalidos){
            throw new IllegalArgumentException("O nome informado contêm caracteres inválidos!");
        }
        
        //Nome com no mínimo 10 caracteres
        if (nomeCompleto.length() < 10){
            throw new IllegalArgumentException("O nome informado deve conter no mínimo 10 caracteres!");
        }

        //Passou por todas as validações
        this.nomeCompleto = nomeCompleto;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    //GETTERS
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getCPF() {
        return CPF;
    }
    public LocalDate getDATANASCIMENTO() {
        return DATANASCIMENTO;
    }
    public Genero getGenero() {
        return genero;
    }
}
