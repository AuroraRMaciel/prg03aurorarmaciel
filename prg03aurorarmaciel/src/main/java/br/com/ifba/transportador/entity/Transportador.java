/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.transportador.entity;

import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
import java.util.List;

/**
 *
 * @author auror
 */
public class Transportador extends Perfil{
    private Pessoa motorista;
    private String cnh;
    private Organizacao empresa;
    private List<String> areaAtuacao;
    private boolean disponivel;
    private double avaliacao;
    
    public Transportador(){
        
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
}
