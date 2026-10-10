/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entrega.entity;

import br.com.ifba.pedido.entity.Pedido;
import br.com.ifba.status.model.StatusEntrega;
import br.com.ifba.transportador.entity.Transportador;
import java.time.LocalDateTime;

/**
 *
 * @author auror
 */
public class Entrega {
    private Pedido pedido;
    private Transportador transportador;
    private StatusEntrega statusEntrega;
    private double valorFrete;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataEntregaPrevista;
    
    public Pedido getPedido(){
        return pedido;
    }
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
    
    public Transportador getTransportador(){
        return transportador;
    }
    public void setTransportador(Transportador transportador){
        this.transportador = transportador;
    }
    
    public StatusEntrega getStatusEntrega(){
        return statusEntrega;
    }
    public void setStatusEntrega(StatusEntrega statusEntrega){
        this.statusEntrega = statusEntrega;
    }
    
    public double getValorFrete(){
        return valorFrete;
    }
    public void setValorFrete(double valorFrete){
        this.valorFrete = valorFrete;
    }
 
    public LocalDateTime getDataEnvio(){
        return dataEnvio;
    }
    public void setDataEnvio(LocalDateTime dataEnvio){
        this.dataEnvio = dataEnvio;
    }
    
    public LocalDateTime getDataEntregaPrevista(){
        return dataEntregaPrevista;
    }
    public void setDataEntregaPrevista(LocalDateTime dataEntregaPrevista){
        this.dataEntregaPrevista = dataEntregaPrevista;
    }
}
