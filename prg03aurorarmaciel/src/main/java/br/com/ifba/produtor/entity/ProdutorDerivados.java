/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.produtor.entity;

import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.produto.entity.Produto;
import java.util.List;

/**
 *
 * @author auror
 */
public class ProdutorDerivados extends Perfil{
    private List<Produto> derivadosDisponiveis;
    private Organizacao associacaoCooperativa;
    private double avaliacao;
    
    public ProdutorDerivados(){
        
    }
    public ProdutorDerivados(Organizacao associacaoCooperativa){
        this.associacaoCooperativa = associacaoCooperativa;
    }
    
    public List<Produto> getDerivadosDisponiveis(){
        return derivadosDisponiveis;
    }
    public void setDerivadosDisponiveis(List<Produto> derivadosDisponiveis){
        this.derivadosDisponiveis = derivadosDisponiveis;
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
    
    //Adiciona derivado na lista de disponiveis
    public void adicionaProdutoALista(Produto produto){
        derivadosDisponiveis.add(produto);
    }
    
    @Override
    public String getTipoPerfil(){
        return "Perfil produtor de derivados";
    }
}
