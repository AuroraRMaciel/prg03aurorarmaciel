/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pedido.entity;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.item.entity.ItemPedido;
import br.com.ifba.status.model.StatusPedido;
import br.com.ifba.tipo.model.FormaPagamento;
import br.com.ifba.usuario.entity.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author auror
 */
public class Pedido {
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private double valorTotal;
    private FormaPagamento formaPagamento;
    private Cliente cliente;
    private Usuario vendedor;
    private List<ItemPedido> itens = new ArrayList<>();
    private boolean isEncomenda;

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public boolean isIsEncomenda() {
        return isEncomenda;
    }

    public void setIsEncomenda(boolean isEncomenda) {
        this.isEncomenda = isEncomenda;
    }
    
    
    
}
