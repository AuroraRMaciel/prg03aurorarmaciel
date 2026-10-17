/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pessoa.entity;

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
@Table (name = "pessoas")
public class Pessoa {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String cpf;
    @Column (name = "nome_completo")
    private String nomeCompleto;
    @Column (name = "data_nascimento")
    private String dataNascimento;
    private String genero;
    
    //Métodos
    public Pessoa(){
        
    }
    public Pessoa(String cpf, String nomeCompleto, String dataNascimento, String genero){
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public long getId() {
        return id;
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
}
