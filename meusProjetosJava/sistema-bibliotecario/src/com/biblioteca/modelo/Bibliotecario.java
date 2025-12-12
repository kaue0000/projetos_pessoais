package com.biblioteca.modelo;
import java.util.Scanner;

public class Bibliotecario extends Pessoa {
    private String credencial;

    public Bibliotecario(String nomeCompleto, String dataNascimento, String cpf, Genero genero, String credencial) {
        super(nomeCompleto, dataNascimento, cpf, genero);
        setCredencial(credencial);
    }
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
    public String getCredencial() {
        return credencial;
    }

    public void adicionarLivro(Estante estante) {
        Scanner sc = new Scanner(System.in);
        String titulo;
        String dataLancamento;
        String isbn;
        String editora;
        String genero;

        System.out.println("CADASTRO DE LIVRO");

        System.out.println("Título: ");
        titulo = sc.nextLine();

        System.out.println("Data de lançamento: ");
        dataLancamento = sc.nextLine();

        System.out.println("ISBN: ");
        isbn = sc.nextLine();

        System.out.println("Editora: ");
        editora = sc.nextLine();

        System.out.println("Gênero: ");
        genero = sc.nextLine();

        //Criando o livro
        Livro novoLivro = new Livro(titulo, dataLancamento, isbn, editora, genero);
        
        estante.adicionarLivro(novoLivro);
    }
    public Autor adicionarAutor() {
        Scanner sc = new Scanner(System.in);

        String nomeCompleto;
        String dataNascimento;
        String cpf;
        String genero;
        String nomeArtistico;

        System.out.println("CADASTRO DE AUTOR");

        System.out.println("Nome completo: ");
        nomeCompleto = sc.nextLine();

        System.out.println("Data de nascimento: ");
        dataNascimento = sc.nextLine();

        System.out.println("CPF: ");
        cpf = sc.nextLine();

        System.out.println("Genero: ");
        genero = sc.nextLine();

        System.out.println("Nome artístico: ");
        nomeArtistico = sc.nextLine();

        if (genero.equalsIgnoreCase("MASCULINO")) {
            return new Autor(nomeCompleto, dataNascimento, cpf, Genero.MASCULINO, nomeArtistico);
        } else {
            
            return new Autor(nomeCompleto, dataNascimento, cpf, Genero.FEMININO, nomeArtistico);
        }
    }
    public void vincularAutorLivro(String tituloLivro, Estante estante) {
        for (Livro livro : estante.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro) && livro.getAutor() == null) {
                Autor novoAutor = adicionarAutor();
                livro.setAutor(novoAutor);
            }
        }
    }
    //Se o autor já estiver cadastrado
    public void vincularAutorLivro(String tituloLivro, Estante estante, Autor autor) {
        for (Livro livro : estante.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro) && livro.getAutor() == null) {
                livro.setAutor(autor);
            }
        }
    }
    public void limparEstante(Estante estante) {
        estante.getLivros().clear();
    }
}
