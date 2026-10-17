/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.organizacao.entity;

import br.com.ifba.tipo.model.TipoOrganizacao;
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
@Table (name = "organizacoes")
public class Organizacao {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private TipoOrganizacao tipo;
    private String cnpj;
    @Column (name = "razao_social")
    private String razaoSocial;
    @Column (name = "inscricao_estadual")
    private String inscricaoEstadual;
    
    //Métodos
    public Organizacao(){
        
    }
    public Organizacao(TipoOrganizacao tipo, String cnpj, String razaoSocial){
        this.tipo = tipo;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public long getId() {
        return id;
    }
    
    public TipoOrganizacao getTipo(){
        return tipo;
    }
    public void setTipo(TipoOrganizacao tipo){
        this.tipo = tipo;
    }
    
    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public String getRazaoSocial(){
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    
    public String getInscricaoEstadual(){
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual){
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
}
