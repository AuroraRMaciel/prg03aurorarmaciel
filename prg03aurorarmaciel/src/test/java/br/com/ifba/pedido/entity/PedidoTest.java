/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pedido.entity;

import br.com.ifba.item.entity.ItemPedido;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author auror
 */
public class PedidoTest {
    @Test
    public void aoAdicionarItemAListaCresce (){
        //Arrange
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido();
        int tamanho = pedido.getItens().size();
        
        //Act
        pedido.adicionarItem(item);
        int tamanhoLista = pedido.getItens().size();
        boolean resultado = tamanhoLista > tamanho;
        
        //Assert
        assertTrue(resultado);
    }
}
