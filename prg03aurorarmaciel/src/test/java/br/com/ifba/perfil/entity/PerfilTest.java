/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfil.entity;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.coletor.entity.Coletor;
import br.com.ifba.organizacao.entity.Organizacao;
import br.com.ifba.status.model.StatusCadastro;
import br.com.ifba.tipo.model.TipoOrganizacao;
import br.com.ifba.transportador.entity.Transportador;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author auror
 */
public class PerfilTest {
    //Testa método herdado
    @Test
    public void deveAprovarCadastroComSucesso(){
        //Arrange
        Coletor coletor = new Coletor();
        
        //Act
        coletor.aprovarCadastro();
                
        //Assert
        assertEquals(StatusCadastro.APROVADO, coletor.getStatusCadastro());
    }
    
    @Test
    public void deveReprovarCadastroComSucesso(){
        //Arrange
        Coletor coletor = new Coletor();
        
        //Act
        coletor.reprovarCadastro();
        
        //Assert
        assertEquals(StatusCadastro.REPROVADO, coletor.getStatusCadastro());
    }
    
    @Test
    public void deveAutenticarQuandoOsDadosSaoValidos(){
        //Arrange
        Organizacao associacao = new Organizacao(TipoOrganizacao.ASSOCIACAO, "01234567890", "EcoCaatinga Social");
        Coletor coletor = new Coletor(associacao);
        coletor.setNome("Aurora");
        coletor.aprovarCadastro();
        
        //Act
        boolean resultado = coletor.validarDados();
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoOsDadosSaoInvalidos(){
        //Arrange
        Coletor coletor = new Coletor();
        
        //Act
        boolean resultado = coletor.validarDados();
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void oCadastroDeveEstarAprovado(){
        //Arrange
        Coletor perfil = new Coletor();
        perfil.aprovarCadastro();
        
        //Act
        boolean resultado = perfil.isAprovado();
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void oCadastroDeveEstarReprovado(){
       //Arrange
       Cliente perfil = new Cliente();
       perfil.reprovarCadastro();
       
       //Act
       boolean resultado = perfil.isAprovado();
       
       //Assert
       assertFalse(resultado);
    }
    
    @Test
    public void deveRetornarPerfilGenerico(){
        //Arrange
        Perfil perfil = new Perfil();
        
        //Assert
        assertEquals(perfil.getTipoPerfil(), "Perfil genérico");
    }
    
    //Testa método subscrito
    @Test
    public void deveAutenticarQuandoOsDadosDoTransportadorSaoValidos(){
        //Arrange
        List<String> areaAtuacao = new ArrayList();
        areaAtuacao.add("Territorio Irecê");
        areaAtuacao.add("Chapada Diamantina");
        Transportador transportador = new Transportador();
        transportador.setNome("Transportador");
        transportador.aprovarCadastro();
        transportador.setCnh("12345678909");
        transportador.setAreaAtuacao(areaAtuacao);
        
        //Act
        boolean resultado = transportador.validarDados();
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoDadosDoTransportadorSaoInvalidos(){
        //Arrange
        Transportador transportador = new Transportador();
        
        //Act
        boolean resultado = transportador.validarDados();
        
        //Assert
        assertFalse(resultado);
    }
}
