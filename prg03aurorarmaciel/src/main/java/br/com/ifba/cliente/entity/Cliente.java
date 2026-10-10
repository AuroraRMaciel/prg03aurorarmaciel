/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.entity;

import br.com.ifba.item.entity.ItemPedido;
import br.com.ifba.pedido.entity.Pedido;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.tipo.model.TipoOrganizacao;
import java.util.List;

/**
 *
 * @author auror
 */
public class Cliente extends Perfil{
    //Atributos
    private TipoOrganizacao tipoCliente;
    private List<ItemPedido> carrinhoCompra;
    private List<Pedido> historicoPedidos;
    private double avaliacao;
    
    //Métodos
    public Cliente(){
        
    }

    public TipoOrganizacao getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoOrganizacao tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<ItemPedido> getCarrinhoCompra() {
        return carrinhoCompra;
    }

    public void setCarrinhoCompra(List<ItemPedido> carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void setHistoricoPedidos(List<Pedido> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    @Override
    public String getTipoPerfil(){
        return "Perfil cliente";
    }
}
