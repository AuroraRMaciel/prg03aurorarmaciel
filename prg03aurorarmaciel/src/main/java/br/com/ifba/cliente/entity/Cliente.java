/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.entity;

import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.tipo.model.TipoOrganizacao;
import java.util.List;

/**
 *
 * @author auror
 */
public class Cliente extends Perfil{
    private TipoOrganizacao tipoCliente;
    private List<String> carrinhoCompra;
    private List<String> historicoPedidos;
    private double avaliacao;
    
    public Cliente(){
        
    }

    public TipoOrganizacao getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoOrganizacao tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<String> getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setCarrinhoCompra(List<String> carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public List<String> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void setHistoricoPedidos(List<String> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
