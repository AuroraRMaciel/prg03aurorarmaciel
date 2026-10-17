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
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author auror
 */
@Entity
@Table (name = "pedidos")
public class Pedido {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column (name = "data_pedido")
    private LocalDateTime dataPedido;
    @Column (name = "status_pedido")
    private StatusPedido statusPedido;
    @Column (name = "valor_total")
    private double valorTotal;
    @Column (name = "forma_pagamento")
    private FormaPagamento formaPagamento;
    private Cliente cliente;
    private Usuario vendedor;
    private List<ItemPedido> itens = new ArrayList<>();
    @Column (name = "is_encomenda")
    private boolean isEncomenda;

    //Métodos
    
    public long getId() {
        return id;
    }

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
    
    public void adicionarItem(ItemPedido item){
        if (item != null){
            itens.add(item);
        }
    }
    
    public double calcularValorTotal(){
        double valor = 0;
        for(int i = 0; i < itens.size(); i++){
            //A cada item da lista valor passa a ser valor + preço unitário daquele índice vezes a quantidade
            valor += itens.get(i).getPrecoUnitario() * itens.get(i).getQuantidade();
        }
        return valor;
    }
    
    
}
