/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.coletor.entity;

import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.produto.entity.Produto;
import java.util.List;

/**
 *
 * @author auror
 */
public class Coletor extends Perfil{
    private List<Produto> produtosDisponiveis;
    private Organizacao associacaoCooperativa;
    private double avaliacao;
    
    public Coletor(){
        
    }
    public Coletor(Organizacao associacaoCooperativa){
        this.associacaoCooperativa = associacaoCooperativa;
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
}
