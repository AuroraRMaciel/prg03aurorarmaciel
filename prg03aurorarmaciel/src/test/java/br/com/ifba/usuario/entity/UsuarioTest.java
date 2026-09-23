/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.ifba.usuario.validar.ValidadorUsuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author auror
 */
public class UsuarioTest {
    
    @Test
    public void deveAutenticarQuandoCredenciaisCorretas(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("aurora", "senha123");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaIncorreta(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678900", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("aurora", "senhaErrada");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoLoginIncorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "senha123");
        
        //Act
        boolean resultado = usuario.autenticar("Aurora", "senha123");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCamposPreenchidos(){
        //Arrange
        Usuario usuario = new Usuario();
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Perfil perfilColetor = new Perfil("Coletor", "Pessoa ou associação que coleta produtos.");
        Perfil perfilProdutor = new Perfil ("Produtor", "Pessoa ou associação que produz derivados.");
        Perfil perfilCliente = new Perfil ("Cliente", "Pessoa ou empresa que compra produtos através da plataforma.");
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(perfilColetor);
        perfis.add(perfilProdutor);
        perfis.add(perfilCliente);
        
        usuario.setPessoa(pessoa);
        usuario.setPerfilAtivo(perfilCliente);
        usuario.setNomeUsuario("Aurora R");
        usuario.setTelefone("74");
        usuario.setEmail("auroramaciel62@gmail.com");
        usuario.setLogin("Aurora");
        usuario.setSenha("Senha123@");
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setUltimoLogin(LocalDateTime.now());
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCamposNaoEstaoPreenchidos(){
        //Arrange
        Pessoa pessoa = new Pessoa ("", "", "", "");
        Usuario usuario = new Usuario(pessoa, "", "");
        usuario.setNomeUsuario("");
        
        //Act
        boolean resultado = ValidadorUsuario.camposPreenchidos(usuario, "Senha123@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhasIguais(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha123@");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhasDiferentes(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhasIguais(usuario, "Senha12@");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoCpfValido(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getPessoa().getCpf());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoCpfInvalido(){
        //Arrange
        Pessoa pessoa = new Pessoa("00000000000", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.cpfValido(usuario.getPessoa().getCpf());
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void deveAutenticarQuandoSenhaForte(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveAutenticarQuandoSenhaFraca(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123");
        
        //Act
        boolean resultado = ValidadorUsuario.senhaForte(usuario.getSenha());
        
        //Assert
        assertFalse(resultado);
    }
}
