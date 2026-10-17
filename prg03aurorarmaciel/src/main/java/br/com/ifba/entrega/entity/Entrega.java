/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entrega.entity;

import br.com.ifba.pedido.entity.Pedido;
import br.com.ifba.status.model.StatusEntrega;
import br.com.ifba.transportador.entity.Transportador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author auror
 */
@Entity
@Table (name = "entregas")
public class Entrega {
    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private Pedido pedido;
    private Transportador transportador;
    @Column (name = "status_entrega")
    private StatusEntrega statusEntrega;
    @Column (name = "valor_frete")
    private double valorFrete;
    @Column (name = "data_envio")
    private LocalDateTime dataEnvio;
    @Column (name = "data_entrega_prevista")
    private LocalDateTime dataEntregaPrevista;
    
    //Métodos
    
    public long getId(){
        return id;
    }

    public Pedido getPedido() {
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
