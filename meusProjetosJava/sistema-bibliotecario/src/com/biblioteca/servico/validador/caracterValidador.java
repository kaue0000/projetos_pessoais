package com.biblioteca.servico.validador;

public class caracterValidador {
    public static boolean verificarCaracterInvalido( String nomeCompleto ){
        Boolean valor = true;
        String valorInvalido = ".*[-!@#$%^&*()+=/\\\\[\\\\]{};':\\\"|,<.>/?`~\\\\\\\\].*";

        if (nomeCompleto.matches(valorInvalido)){
            valor = false;
        }
        return valor;

    }
    public static boolean validarTelefone( String telefone ){
        //
        return true;
    }
    public static boolean tamanhoMinino(String texto) {
        if (texto.length() >= 4) 
            return true;
        return false;
    }
}
