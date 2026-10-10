/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author auror
 */
public class RepositorioUsuarioEmMemoriaTest {
    @Test
    public void cadastraUmUsuarioEEleApareceEmListarTodos(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa1 = new Pessoa("12345678907", "João Santos", "15/03", "M");
        
        Usuario usuario = new Usuario(pessoa, "Aurora", "senha123");
        Usuario usuario1 = new Usuario(pessoa1, "João", "Senha@");
        
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        repositorio.cadastrarUsuario(usuario);
        repositorio.cadastrarUsuario(usuario1);
        
        List<Usuario> lista = new ArrayList<>();
        lista = repositorio.listarTodos();

        //Act
        boolean resultado = lista.contains(usuario);
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void cadastraDoisUsuariosEBuscarPorLoginRetornaCerto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa1 = new Pessoa("12345678907", "João Santos", "15/03", "M");
        
        Usuario usuario = new Usuario(pessoa, "Aurora", "senha123");
        Usuario usuario1 = new Usuario(pessoa1, "João", "Senha@");
        
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        repositorio.cadastrarUsuario(usuario);
        repositorio.cadastrarUsuario(usuario1);
        
        Usuario encontrado = repositorio.buscarPorLogin("João");
        
        //Act
        boolean resultado = encontrado != null;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void cadastraDoisUsuariosEBuscarPorLoginRetornaNull(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa1 = new Pessoa("12345678907", "João Santos", "15/03", "M");
        
        Usuario usuario = new Usuario(pessoa, "Aurora", "senha123");
        Usuario usuario1 = new Usuario(pessoa1, "João", "Senha@");
        
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        repositorio.cadastrarUsuario(usuario);
        repositorio.cadastrarUsuario(usuario1);
        
        //Busca por um login que nao existe
        Usuario encontrado = repositorio.buscarPorLogin("Joao");
        
        //Act
        boolean resultado = encontrado != null;
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void cadastraDoisUsuariosEBuscaPorLoginRetornaCerto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa1 = new Pessoa("12345678907", "João Santos", "15/03", "M");
        
        Usuario usuario = new Usuario(pessoa, "Aurora", "senha123");
        Usuario usuario1 = new Usuario(pessoa1, "João", "Senha@");
        
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        repositorio.cadastrarUsuario(usuario);
        repositorio.cadastrarUsuario(usuario1);
        
        Usuario encontrado = repositorio.buscaPorLogin("João");
        
        //Act
        boolean resultado = encontrado != null;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void cadastraDoisUsuariosEBuscaPorLoginRetornaNull(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa1 = new Pessoa("12345678907", "João Santos", "15/03", "M");
        
        Usuario usuario = new Usuario(pessoa, "Aurora", "senha123");
        Usuario usuario1 = new Usuario(pessoa1, "João", "Senha@");
        
        RepositorioUsuarioEmMemoria repositorio = new RepositorioUsuarioEmMemoria();
        repositorio.cadastrarUsuario(usuario);
        repositorio.cadastrarUsuario(usuario1);
        
        //Busca por um login que não existe
        Usuario encontrado = repositorio.buscaPorLogin("Joao");
        
        //Act
        boolean resultado = encontrado != null;
        
        //Assert
        assertFalse(resultado);
    }
}
