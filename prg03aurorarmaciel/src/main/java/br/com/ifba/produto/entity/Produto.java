/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.produto.entity;

import br.com.ifba.tipo.model.TipoProduto;
import br.com.ifba.unidade.model.UnidadeMedida;
import br.com.ifba.usuario.entity.Usuario;

/**
 *
 * @author auror
 */
public class Produto {
    private String nome;
    private TipoProduto categoria;
    private UnidadeMedida unidadeMedida;
    private double quantidadeDisponivel;
    private Usuario vendedor;
    
    public Produto(){
        
    }
    public Produto(String nome){
        this.nome = nome;
    }
    public Produto(String nome, UnidadeMedida unidadeMedida, double quantidadeDisponivel){
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
     public TipoProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoProduto categoria) {
        this.categoria = categoria;
    }
    
    public UnidadeMedida getUnidadeMedida(){
        return unidadeMedida;
    }
    public void setUnidadeMedida(UnidadeMedida unidadeMedida){
        this.unidadeMedida = unidadeMedida;
    }
    
    public double getQuantidadeDisponivel(){
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(double quantidadeDisponivel){
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
    public Usuario getVendedor(){
        return vendedor;
    }
    public void setVendedor(Usuario vendedor){
        this.vendedor = vendedor;
    }
}
