/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.produto.entity;

import br.com.ifba.tipo.model.TipoProduto;
import br.com.ifba.unidade.model.UnidadeMedida;
import br.com.ifba.usuario.entity.Usuario;
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
@Table (name = "produtos")
public class Produto {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private TipoProduto categoria;
    @Column (name = "unidade_medida")
    private UnidadeMedida unidadeMedida;
    @Column (name = "quantidade_disponivel")
    private double quantidadeDisponivel;
    private Usuario vendedor;
    
    //Métodos
    public Produto(){
        
    }
    public Produto(String nome){
        this.nome = nome;
    }
    public Produto(String nome, TipoProduto categoria, UnidadeMedida unidadeMedida, double quantidadeDisponivel, Usuario vendedor){
        this.nome = nome;
        this.categoria = categoria;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.vendedor = vendedor;
    }

    public long getId() {
        return id;
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
    
    public void atualizarEstoque (double quantidadeVendida){
        quantidadeDisponivel = quantidadeDisponivel - quantidadeVendida;
    }
}
