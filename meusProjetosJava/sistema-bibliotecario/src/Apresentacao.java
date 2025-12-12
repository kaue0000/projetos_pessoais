import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Bibliotecario;
import com.biblioteca.modelo.Cliente;
import com.biblioteca.modelo.Endereco;
import com.biblioteca.modelo.Estante;
import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Pessoa.Genero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Apresentacao {
    public static void main(String[] args) {
        //Criação do cliente
        
        Endereco meuEndereco = new Endereco(
            "Brasil", 
            "Acari",
            "Padre José Dantas Cortez", 
            "15 de Agosto",   
            "18");

        Cliente cliente = new Cliente(
            "Kauê Adriano", 
            "2003-09-05", 
            "356735688", 
            Genero.MASCULINO,    
            "36667755334",
            meuEndereco);

        Autor autor = new Autor(
            "Haruko Ichikawa", 
            "1980-11-22", 
            "45454545", 
            Genero.FEMININO,
            "Ichikawa");
        
        Bibliotecario bibliotecario = new Bibliotecario(
            "João Neves", 
            "1995-10-10", 
            "45454575", 
            Genero.MASCULINO, 
            "5454572");

        Livro livro1 = new Livro(
            "Houseki no Kuni", 
            autor, 
            "2011-05-25",
            "564545", 
            "Editorak", 
            "Horror");
        
        Livro livro2 = new Livro(
            "Percy Jackson", 
            autor, 
            "2020-01-07", 
            "565656", 
            "Miii", 
            "Ficção");

        Livro livro3 = new Livro(
            "A menina que roubava livros", 
            autor,
            "2007-03-06", 
            "3434656", 
            "Nova Editora", 
            "Drama");

        Estante estante = new Estante(new ArrayList<>(Arrays.asList(livro1, livro2, livro3)));

        Scanner sc = new Scanner(System.in); 

        String titulo;
        Integer escolha;

        System.out.println("Bem vindo ao sistema bibliotecário!!");
        
        System.out.println("Qual sua função?");
        System.out.println(": ");
        String funcao = sc.nextLine();

        funcao = funcao.toUpperCase();
        switch (funcao) {
            case "CLIENTE":
                while (true) {
                    System.out.println("O que deseja fazer, como cliente? ");
                    System.out.println("0 - SAIR\n1 - Verificar disponibilidade\n2 - Verificar status\n3 - Realizar empréstimo\n4 - Devolver empréstimo\n5 - Visualizar estante\n6 - Visualizar estante organizada\n7 - Visualizar quantidade de empréstimos\n8 - Visualizar empréstimos\n9 - Visualizar quantidade de penalizações");
                    System.out.println(": ");
                    escolha = sc.nextInt();
                    switch(escolha){
                        case 0:
                            System.out.println("Saindo...");
                            sc.close();
                            return;
                        case 1:
                            sc.nextLine();
                            //Buscar livro pelo titulo
                            System.out.println("Título do livro: ");
                            titulo = sc.nextLine();
                            boolean disponivel = cliente.verificarDisponibilidade(titulo, estante);
                            if (disponivel) {
                                System.out.println("Este livro está disponível nessa biblioteca.");
                            } else {
                                System.out.println("Este livro NÃO está disponível nessa biblioteca.");
                            }
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Qual livro deseja verificar o status? ");
                            titulo = sc.nextLine();

                            boolean livroDisponivelEmprestimo = cliente.verificarStatus(titulo, estante);

                            if (livroDisponivelEmprestimo) {
                                System.out.println("Este livro está disponível para empréstimo.");
                            } else {
                                System.out.println("Este livro NÃO está disponível para empréstimo.");
                            }
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.println("Qual livro deseja realizar empréstimo? ");
                            titulo = sc.nextLine();

                            boolean emprestimoRealizado = cliente.realizarEmprestimo(titulo, estante, cliente);

                            if (emprestimoRealizado) {
                                System.out.println("Empréstimo realizado com sucesso.");
                            } else {
                                System.out.println("Não foi possível realizar o empréstimo.");
                            }
                            break;
                        case 4:
                            sc.nextLine();
                            System.out.println("Qual livro deseja devolver empréstimo? ");
                            titulo = sc.nextLine();

                            boolean devolucaoRealizada = cliente.devolverEmprestimo(titulo, estante, cliente);

                            if (devolucaoRealizada) {
                                System.out.println("Devolução realizada com sucesso.");
                            } else {
                                System.out.println("Não foi possível realizar a devolução.");
                            }
                            break;
                        case 5:
                            cliente.visualizarEstante(estante);
                            break;
                        case 6:
                            cliente.visualizarEstanteOrdenada(estante);
                            break;
                        case 7: 
                        int qtdEmprestimos = cliente.qtdEmprestimos(cliente);
                        System.out.println("Quantidade empréstimos: " + qtdEmprestimos);
                            break;
                        case 8:
                            cliente.visualizarEmprestimos(cliente);
                            break;
                        case 9:
                            cliente.visualizarQtdPenalizacao(cliente);
                            break;
                        } 
                    }
            case "BIBLIOTECARIO":
                while (true) {
                    System.out.println("O que deseja fazer, como bibliotecário? ");
                    System.out.println("0 - SAIR\n1 - Adicionar livro\n2 - Vincular autor ao livro\n3 - Limpar/Apagar livros da estante");
                    System.out.println(": ");
                    escolha = sc.nextInt();

                    switch(escolha) {
                        case 0:
                            System.out.println("Saindo...");
                            sc.close();
                            return;
                        case 1:
                            sc.nextLine();
                            bibliotecario.adicionarLivro(estante);
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Título do livro: ");
                            titulo = sc.nextLine();
                            bibliotecario.vincularAutorLivro(titulo, estante);
                            break;
                        case 3:
                            sc.nextLine();
                            bibliotecario.limparEstante(estante);
                    }
                }
                }
            }
    }
