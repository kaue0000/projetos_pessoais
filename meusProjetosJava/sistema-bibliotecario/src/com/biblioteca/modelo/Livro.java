package com.biblioteca.modelo;

import java.time.*;

import com.biblioteca.servico.validador.caracterValidador;

public class Livro {
    public enum Status {
        DISPONIVEL,
        INDISPONIVEL
    }
    private String titulo;
    private Autor autor;
    private final LocalDate DATALANCAMENTO;
    private Status status; //Se está disponível para emprestímo ou não
    private final String ISBN;
    private String editora;
    private String genero;

    public Livro(String titulo, Autor autor, String dataLancamento, String isbn, String editora, String genero) {
        setTitulo(titulo);
        setAutor(autor);
        this.DATALANCAMENTO = LocalDate.parse(dataLancamento);
        this.status = Status.DISPONIVEL;
        this.ISBN = isbn;
        setEditora(editora);
        setGenero(genero);
    }
    public Livro(String titulo, String dataLancamento, String isbn, String editora, String genero) {
        setTitulo(titulo);
        this.DATALANCAMENTO = LocalDate.parse(dataLancamento);
        this.status = Status.DISPONIVEL;
        this.ISBN = isbn;
        setEditora(editora);
        setGenero(genero);
    }

    public void setTitulo(String titulo) {
        if (caracterValidador.tamanhoMinino(titulo))
            this.titulo = titulo;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setEditora(String editora) {
        if (caracterValidador.tamanhoMinino(editora))
            this.editora = editora;
    }
    public void setGenero(String genero) {
        if (caracterValidador.tamanhoMinino(genero)) 
            this.genero = genero;
    }

    public LocalDate getDATALANCAMENTO() {
        return DATALANCAMENTO;
    }
    public String getTitulo() {
        return titulo;
    }
    public Autor getAutor() {
        return autor;
    }
    public Status getStatus() {
        return status;
    }
    public String getEditora() {
        return editora;
    }
    public String getGenero() {
        return genero;
    }
    public String getISBN() {
        return ISBN;
    }
    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor(a): " + autor.getNomeArtistico() + 
        "\nData de lançamento: " + DATALANCAMENTO + "\nStatus: " + status + 
        "\nEditora: " + editora + "\nGenero: " + genero + "\n";
    }
    
}
