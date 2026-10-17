/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.coletor.entity;

import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.produto.entity.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author auror
 */
@Entity
@Table (name = "coletores")
public class Coletor extends Perfil{
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private List<Produto> produtosDisponiveis;
    @Column (name = "associacao_cooperativa")
    private Organizacao associacaoCooperativa;
    private double avaliacao;
    
    //Métodos
    public Coletor(){
        
    }
    public Coletor(Organizacao associacaoCooperativa){
        this.associacaoCooperativa = associacaoCooperativa;
    }

    public long getId() {
        return id;
    }
    
    public List<Produto> getProdutosDisponiveis() {
        return produtosDisponiveis;
    }

    public void setProdutosDisponiveis(List<Produto> produtosDisponiveis) {
        this.produtosDisponiveis = produtosDisponiveis;
    }

    public Organizacao getAssociacaoCooperativa() {
        return associacaoCooperativa;
    }

    public void setAssociacaoCooperativa(Organizacao associacaoCooperativa) {
        this.associacaoCooperativa = associacaoCooperativa;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    //Adiciona produto a lista de produtos disponiveis
    public void adicionarProdutoALista(Produto produto){
        produtosDisponiveis.add(produto);
    }
    
    @Override
    public String getTipoPerfil(){
        return "Perfil coletor de frutos nativos";
    }
}
