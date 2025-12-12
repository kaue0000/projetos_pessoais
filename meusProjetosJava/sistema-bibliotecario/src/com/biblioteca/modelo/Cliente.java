package com.biblioteca.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.biblioteca.modelo.Livro.Status;

public class Cliente extends Pessoa {
    //Endereço para fazer cobrança
    private Endereco endereco;
    private String telefone;
    private Integer pontosPenalizacao;
    private List<Emprestimo> emprestimos;
    //CONSTRUTOR
    public Cliente(String nomeCompleto, String dataNascimento, String cpf, Genero genero, String telefone, Endereco endereco) {
        super(nomeCompleto, dataNascimento, cpf, genero);
        setEndereco(endereco);
        setTelefone(telefone);
        setPontosPenalizacao(0);
        setEmprestimos(emprestimos);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        if (telefone.length() < 9){
            throw new IllegalArgumentException("Informe um número de telefone com no mínimo 10 caracteres.");
        }
        if (telefone.length() > 12){
            throw new IllegalArgumentException("Informe um número de telefone com no máximo 12 caracteres.");
        }
        try{
            Long.parseLong(telefone);

            this.telefone = telefone;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Informe caracteres válidos.");
        }
    }
    public void setPontosPenalizacao(Integer pontosPenalizacao) {
        this.pontosPenalizacao = pontosPenalizacao;
    }
    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = new ArrayList<>();;
    }

    public String getTelefone() {
        return telefone;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public Integer getPontosPenalizacao() {
        return pontosPenalizacao;
    }
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void visualizarEstante(Estante estante) {
        if (estante.getLivros().isEmpty()) {
            System.out.println("A estante está vazia.");
        }
        for (Livro livro : estante.getLivros()) {
            if (livro.getAutor() != null) {
                System.out.println(livro.toString());
            }
        }
    }
    public void visualizarEstanteOrdenada(Estante estante) {
        if (estante.getLivros().isEmpty()) {
            System.out.println("A estante está vazia.");
        } else {
            exibirLivrosOrdenados(estante);
    }
    }
    public void exibirLivrosOrdenados(Estante estante) {
        List<Livro> livrosOriginais = estante.getLivros();
        livrosOriginais.stream().sorted(Comparator.comparing(Livro::getTitulo)).forEach(livro -> System.out.println(livro.toString()));
    }
    public boolean verificarDisponibilidade(String titulo, Estante estante) {
        for (Livro livro : estante.getLivros()) {
            boolean livroEncontrado = this.procurarLivro(livro, titulo);
            if (livroEncontrado)
                return true;
        }
        return false;
    }
    public boolean procurarLivro(Livro livro, String titulo) {
        if (livro.getTitulo().equalsIgnoreCase(titulo)) 
            return true;
        return false;
    }
    public boolean verificarStatus(String titulo, Estante estante) {
        for (Livro livro : estante.getLivros()) {
            boolean livroDisponivel = livro.getTitulo().equalsIgnoreCase(titulo) && livro.getStatus() == Status.DISPONIVEL;
            if (livroDisponivel) 
                return true;
        }
        return false;
}
    public boolean realizarEmprestimo(String titulo, Estante estante, Cliente cliente) {
        for (Livro livro : estante.getLivros()) {
            boolean livroEmprestavel = verificarStatus(titulo, estante);
            if (livroEmprestavel) {
                this.cadastrarEmprestimo(livro, cliente);
                return true;
                }
        }
        return false;
    }
    public void cadastrarEmprestimo(Livro livro, Cliente cliente) {
        livro.setStatus(Status.INDISPONIVEL);
        Emprestimo novoEmprestimo = new Emprestimo(livro, cliente);
        cliente.emprestimos.add(novoEmprestimo);
    }
    public boolean devolverEmprestimo(String titulo, Estante estante, Cliente cliente) {
        for (Livro livro : estante.getLivros()) {
            boolean livroDevolvivel = !verificarStatus(titulo, estante);
            if (livroDevolvivel)
                this.cadastrarDevolucao(livro, cliente);
                return true;
            }
        return false;
    }
    public void cadastrarDevolucao(Livro livro, Cliente cliente) {
        livro.setStatus(Status.DISPONIVEL);
        //Percorrer os empréstimos do cliente para achar o correspondente
        marcarDevolucaoEntregue(livro, cliente);
    }
    public void marcarDevolucaoEntregue(Livro livro, Cliente cliente) {
        Iterator<Emprestimo> iterator = cliente.emprestimos.iterator(); 
        while(iterator.hasNext()) {
            Emprestimo emprestimoAtual = iterator.next();
            boolean devolucaoAutorizada = emprestimoAtual.geStatus() == com.biblioteca.modelo.Emprestimo.Status.ATIVO && 
            emprestimoAtual.getLivro().getTitulo().equalsIgnoreCase(livro.getTitulo());
            if (devolucaoAutorizada) {
                emprestimoAtual.setStatus(com.biblioteca.modelo.Emprestimo.Status.ENTREGUE);
            }
            boolean entregaAtrasada = (LocalDate.now().isAfter(emprestimoAtual.getDataDevolucao()));
            if (entregaAtrasada) {
                penalizarAtraso(emprestimoAtual);
            }
        }
    }
    public void penalizarAtraso(Emprestimo emprestimoAtual) {
        emprestimoAtual.setStatus(com.biblioteca.modelo.Emprestimo.Status.MULTADO);
        emprestimoAtual.getResponsavel().setPontosPenalizacao(+10);
    }
    public void visualizarEmprestimos(Cliente cliente) {
        if (cliente.emprestimos.isEmpty()) {
            System.out.println("O cliente " + cliente.getNomeCompleto() + " não tem nenhum empréstimo cadastrado.");
            return;
        }
        Iterator<Emprestimo> emprestimo = cliente.emprestimos.iterator();
        while (emprestimo.hasNext()) {
            Emprestimo proximo = emprestimo.next();
            System.out.println("Livro: " + proximo.getLivro().getTitulo());
            System.out.println("Data de empréstimo: " + proximo.getDataEmprestimo());
            System.out.println("Data de devolução: " + proximo.getDataDevolucao());
            System.out.println("Status: " + proximo.geStatus());
        }
    }
    public int qtdEmprestimos(Cliente cliente) {
        boolean emprestimosVazio = cliente.emprestimos.isEmpty();
        if (!emprestimosVazio) {
            return cliente.emprestimos.size();
        }
        return 0;
    }
    public void visualizarQtdPenalizacao(Cliente cliente) {
        System.out.println("Quantidade de penalizações: " + cliente.getPontosPenalizacao());
    }
}