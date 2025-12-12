package com.musica.modulo;

import java.time.LocalDate;
import java.util.Objects;

public class Musica {
    private Artista artista;
    private String nome;
    private String linguagem;
    private String genero;
    private LocalDate dataLancamento;
    private String gravadora;
    private Integer segundos;

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    public Artista getArtista() {
        return artista;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
    public String getLinguagem() {
        return linguagem;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    public String getGravadora() {
        return gravadora;
    }
    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }
    public Integer getSegundos() {
        return segundos;
    }
    @Override
    public String toString() {
        return "{ " + "Nome: " + getNome() + " | Artista: " + getArtista().getNome() + " }";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        // Considera que duas músicas são iguais se tiverem o mesmo título E artista
        return Objects.equals(nome, musica.nome) &&
               Objects.equals(artista, musica.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, artista);
    }
}
