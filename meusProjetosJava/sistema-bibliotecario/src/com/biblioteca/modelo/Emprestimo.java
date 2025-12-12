package com.biblioteca.modelo;

import java.time.*;

public class Emprestimo {
    public enum Status {
        ATIVO,
        ENTREGUE,
        MULTADO
    }
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Cliente responsavel;
    private Status status;

    public Emprestimo() {

    }
    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro, Cliente responsavel) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.responsavel = responsavel;
        this.status = Status.ATIVO;
    }
    public Emprestimo(Livro livro, Cliente responsavel) {
        setLivro(livro);
        setResponsavel(responsavel);
        setDataEmprestimo(dataEmprestimo);
        setDataDevolucao();
        this.status = Status.ATIVO;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        if (dataEmprestimo.isEqual(LocalDate.now()) || dataEmprestimo.isAfter(LocalDate.now())) {
            this.dataEmprestimo = dataEmprestimo;
        }
    }
    public void setDataDevolucao() {
        this.dataDevolucao = this.dataEmprestimo.plusDays(15);
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public Livro getLivro() {
        return livro;
    }
    public Cliente getResponsavel() {
        return responsavel;
    }
    public Status geStatus () {
        return status;
    }
}
