package com.biblioteca.modelo;

public class Autor extends Pessoa {
    private String nomeArtistico;

    public Autor(String nomeCompleto, String dataNascimento, String cpf, Genero genero, String nomeArtistico) {
        super(nomeCompleto, dataNascimento, cpf, genero);
        this.nomeArtistico = nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }
    
    public String getNomeArtistico() {
        return nomeArtistico;
    }
}
