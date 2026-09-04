/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;

/**
 *
 * @author auror
 */
public class ValidadorCadastro {
    public static boolean contemPalavraProibida(String texto){
        //Cria o array de string com palavras proibidas
        String palavrasProibidas[] = {"admin", "teste", "root", "senha123"};
        
        //For-each que percorre o vetor
        for (String palavra: palavrasProibidas){
            //Verifica se a palavra é igual ao texto recibido como parâmetro retorna true
            if (palavra.equals(texto) == true){
                return true;
            }
        }
        //Caso não encontre palavra igual no vetor retorna false
        return false;
    }
}
