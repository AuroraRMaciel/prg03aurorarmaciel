/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.ifba.usuario.validar.ValidadorUsuario;

/**
 *
 * @author auror
 */
public class UsuarioTest {
    
    @Test
    public void deveAutenticarQuandoCredenciaisCorretas(){
        //Arrange
        Usuario usuario = new Usuario ("Aurora", "12345678900",
                                        "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("aurora", "senha123");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaIncorreta(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678900",
                                        "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("aurora", "senhaErrada");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoLoginIncorreto(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678900",
                                        "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("Aurora", "senha123");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCamposPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario();
        usuario.setNome("Aurora Rodrigues");
        usuario.setCpf("12345678909");
        usuario.setGenero("Feminino");
        usuario.setDataNascimento("23/01");
        usuario.setTelefone("74");
        usuario.setEmail("auroramaciel62@gmail.com");
        usuario.setLogin("Aurora");
        usuario.setSenha("Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCamposNaoEstaoPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario("", "", "", "");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhasIguais(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678909", "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhasDiferentes(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678909", "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha12@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCpfValido(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678909", "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getCpf());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCpfInvalido(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "00000000000", "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getCpf());
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhaForte(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678909", "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaFraca(){
        //Arrange
        Usuario usuario = new Usuario("Aurora", "12345678909", "aurora", "Senha123");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertFalse(resultado);
    }
}
