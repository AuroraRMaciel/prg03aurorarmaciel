/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.transportador.entity;

import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
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
@Table (name = "transportadores")
public class Transportador extends Perfil{
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private Pessoa motorista;
    private String cnh;
    private Organizacao empresa;
    private List<String> areaAtuacao;
    private boolean disponivel;
    private double avaliacao;
    
    //Métodos
    public Transportador(){
        
    }

    public long getId() {
        return id;
    }

    public Pessoa getMotorista() {
        return motorista;
    }

    public void setMotorista(Pessoa motorista) {
        this.motorista = motorista;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Organizacao getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Organizacao empresa) {
        this.empresa = empresa;
    }

    public List<String> getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(List<String> areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    @Override
    public boolean validarDados(){
        //Se os dados da super classe nao estiver validos
        if (!super.validarDados()){
            return false;
        }
        
        //Se cnh for nula ou vazia 
        if (this.cnh == null || this.cnh.trim().isEmpty()){
            return false;
        }
        //Se a area de atuacao for nula ou vazia
        if (this.areaAtuacao == null || this.areaAtuacao.isEmpty()){
            return false;
        }
        return true;
    }
    
    @Override
    public String getTipoPerfil(){
        return "Perfil Transportador/Logistica";
    }
}
