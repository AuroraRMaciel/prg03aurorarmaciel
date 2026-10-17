/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.item.entity;

import br.com.ifba.produto.entity.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author auror
 */
@Entity
@Table (name = "itens_pedidos")
public class ItemPedido {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private Produto produto;
    private double quantidade;
    @Column (name = "preco_unitario")
    private double precoUnitario;
    
    //Métodos
    
    public long getId(){
        return id;
    }

    public Produto getProduto() {
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
