/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.entity;

import br.com.ifba.status.model.StatusCadastro;

/**
 *
 * @author auror
 */
public class Perfil{
    private String nome;
    private String descricao;
    private boolean imutavel;
    private String imagemUrl;
    private StatusCadastro statusCadastro;
    
    public Perfil(){
        
    }
    public Perfil(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public boolean getImutavel(){
        return imutavel;
    }
    public void setImutavel(boolean imutavel){
        this.imutavel = imutavel;
    }
    
    public String getImagemUrl(){
        return imagemUrl;
    }
    public void setImagemUrl(String imagemUrl){
        this.imagemUrl = imagemUrl;
    }

    public StatusCadastro getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(StatusCadastro statusCadastro) {
        this.statusCadastro = statusCadastro;
    }
    
    public void aprovarCadastro(){
        this.statusCadastro = StatusCadastro.APROVADO;
    }
    
    public void reprovarCadastro(){
        this.statusCadastro = StatusCadastro.REPROVADO;
    }
    
    public boolean isAprovado(){
        if (this.statusCadastro == StatusCadastro.APROVADO){
            return true;
        }
        return false;
    }
    
    public boolean validarDados(){
      //Nome nulo ou vazio
      if (this.nome == null || this.nome.trim().isEmpty()){
          return false;
      } 
      //Se status nulo
      if (this.statusCadastro == null){
          return false;
      }
      return true;
    }
    
    public String getTipoPerfil(){
        return "Perfil genérico";
    }
    
    
}
