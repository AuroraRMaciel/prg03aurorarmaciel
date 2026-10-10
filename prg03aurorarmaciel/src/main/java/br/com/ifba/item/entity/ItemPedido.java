/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.item.entity;

import br.com.ifba.produto.entity.Produto;

/**
 *
 * @author auror
 */
public class ItemPedido {
    //Atributos
    private Produto produto;
    private double quantidade;
    private double precoUnitario;
    
    //Métodos
    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public double getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }
    
    public double getPrecoUnitario(){
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }
}
