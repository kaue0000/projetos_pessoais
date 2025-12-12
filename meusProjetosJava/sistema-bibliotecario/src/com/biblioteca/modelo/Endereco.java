package com.biblioteca.modelo;
import com.biblioteca.servico.validador.caracterValidador;

public class Endereco {
    //ATRIBUTOS
    private String pais;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    //CONSTRUTOR
    public Endereco(String pais, String cidade, String bairro, String rua, String numero) {
        setPais(pais);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumero(numero);
    }
    //SETTERS
    public void setPais(String pais) {
        if (!caracterValidador.verificarCaracterInvalido(pais)){
            throw new IllegalArgumentException("O país informado contêm caracteres inválidos!");
        }
        //Levei em consideração que o menor nome de país que me recordo é "fiji"
        if (pais.length() < 4){
            throw new IllegalArgumentException("O país informado deve conter no mínimo 4 caracteres!");
        }
        this.pais = pais;
    }
    public void setCidade(String cidade) {
        if (!caracterValidador.verificarCaracterInvalido(cidade)){
            throw new IllegalArgumentException("A cidade informada contêm caracteres inválidos!");
        }
        if (cidade.length() < 4){
            throw new IllegalArgumentException("A cidade informada deve conter no mínimo 4 caracteres!");
        }
        this.cidade = cidade;
    }
    public void setBairro(String bairro) {
        if (!caracterValidador.verificarCaracterInvalido(bairro)){
            throw new IllegalArgumentException("O bairro informado contêm caracteres inválidos!");
        }
        if (bairro.length() < 4){
            throw new IllegalArgumentException("O bairro informado deve conter no mínimo 4 caracteres!");
        }
        this.bairro = bairro;
    }
    public void setRua(String rua) {
        if (!caracterValidador.verificarCaracterInvalido(rua)){
            throw new IllegalArgumentException("A rua informada contêm caracteres inválidos!");
        }
        if (rua.length() < 4){
            throw new IllegalArgumentException("A rua informada deve conter no mínimo 4 caracteres!");
        }
        this.rua = rua;
    }
    public void setNumero(String numero) {
        try{
            int numeroConvertido = Integer.parseInt(numero);

            if (numeroConvertido < 0) {
                throw new IllegalArgumentException("O número não pode ser negativo.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("O valor fornecido não é um número inteiro válido.", e);
        }

        if (!caracterValidador.verificarCaracterInvalido(numero)){
            throw new IllegalArgumentException("O número informado contêm caracteres inválidos!");
        }

        if (numero.length() < 0){
            throw new IllegalArgumentException("O número informado deve conter no mínimo 1 caractere!");
        }
        this.numero = numero;
        }

    //GETTERS
    public String getPais() {
        return pais;
    }
    public String getCidade() {
        return cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public String getRua() {
        return rua;
    }
    public String getNumero() {
        return numero;
    }
    //"Transforma" o objeto em string. Importante para imprimir na tela
    @Override 
    public String toString() {
        return "\nPais: " + this.pais + ", Cidade: " + this.cidade + ". Bairro: " + this.bairro + ", Rua: " + this.rua + ", Número: " + this.numero ;
    }
    }