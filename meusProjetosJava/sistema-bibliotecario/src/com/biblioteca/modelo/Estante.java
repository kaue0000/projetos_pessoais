package com.biblioteca.modelo;
import java.util.List; 

public class Estante {
    private List<Livro> livros;

    public Estante() {}

    public Estante(List<Livro> livros) {
        setLivros(livros);
    }

    public void adicionarLivro(Livro novoLivro) {
        this.livros.add(novoLivro);
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    @Override
    public String toString() {
        return livros.toString();
    }
}
