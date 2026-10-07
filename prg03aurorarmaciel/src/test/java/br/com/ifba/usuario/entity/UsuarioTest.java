/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.status.model.Status;
import br.com.ifba.usuario.interfaces.Autenticavel;
import br.com.ifba.usuario.repository.RepositorioUsuarioEmMemoria;
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
    
    @Test
    public void aoAdicionarPerfilAlistaCresce(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        Perfil perfil = new Perfil("Cliente", "Possível comprador dos produtos");
        
        //Act
        int tamanhoListaOriginal = usuario.getPerfis().size();
        usuario.adicionarPerfilALista(perfil);
        int tamanhoListaAtualizado = usuario.getPerfis().size();
        boolean resultado = tamanhoListaAtualizado > tamanhoListaOriginal;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void objetoCriadoNasceComStatusCorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        Status status = Status.INATIVO;
        
        //Act
        boolean resultado = usuario.getStatus() == status;
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void objetoNasceComStatusCorreto(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
        Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
        Status status = Status.INATIVO;
        
        //Assert
        assertEquals(usuario.getStatus(), status);
    }
    
    @Test
    public void oObjetoRelacionadoEdevolvidoPeloGetter(){
       //Arrange
       Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "Feminino");
       Usuario usuario = new Usuario(pessoa, "aurora", "Senha123@");
       
       //Act
       Pessoa pessoa2 = usuario.getPessoa();
       
       //Assert
       assertEquals(pessoa, pessoa2);
       
         
    }
    //Task 05
    @Test 
    public void aAutenticacaoDoUsuarioDeveRetornarTrue(){
        //Arrange
        Autenticavel usuario = new Usuario("Aurora", "Senha123");
        
        //Act
        boolean resultado = usuario.autenticar("Aurora", "Senha123");
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void aAutenticacaoDoUsuarioDeveRetornarFalse(){
        //Arrange
        Autenticavel usuario = new Usuario("Aurora", "Senha123");
        
        //Act
        boolean resultado = usuario.autenticar("aurora", "senha123");
        
        //Assert
        assertFalse(resultado);
    }
    
    @Test
    public void testaAIgualdadeDeObjetosDoTipoUsuarioPeloCpfComOEqualsDeUsuario(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Usuario usuario1 = new Usuario(pessoa, "Aurora", "Senha123@");
        Usuario usuario2 = new Usuario(pessoa, "auroraRodrigues", "Senha123");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        //Act
        boolean resultado = usuarios.get(0).equals(usuarios.get(1));
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void testaADiferencaDeObjetosDoTipoUsuarioPeloCpfComEqualsDeUsuario(){
        //Arrange
        Pessoa pessoa1 = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa2 = new Pessoa("12345678908", "Aurora Rodrigues", "28/05", "F");
        
        Usuario usuario1 = new Usuario(pessoa1, "Aurora", "Senha123");
        Usuario usuario2 = new Usuario(pessoa2, "auroraRodrigues", "senha123@");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        //Act
        boolean resultado = usuarios.get(0).equals(usuarios.get(1));
        
        //Assert
        assertFalse(resultado);
    }
    @Test
    public void testaAIgualdadeDeObjetosDoTipoUsuarioPeloCpfComOHashCodeDeUsuario(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Usuario usuario1 = new Usuario(pessoa, "Aurora", "Senha123@");
        Usuario usuario2 = new Usuario(pessoa, "auroraRodrigues", "Senha123");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        //Act
        boolean resultado = usuarios.get(0).hashCode() == usuarios.get(1).hashCode();
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void testaADiferencaDeObjetosDoTipoUsuarioPeloCpfComHashCodeDeUsuario(){
        //Arrange
        Pessoa pessoa1 = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa2 = new Pessoa("12345678908", "Aurora Rodrigues", "28/05", "F");
        
        Usuario usuario1 = new Usuario(pessoa1, "Aurora", "Senha123");
        Usuario usuario2 = new Usuario(pessoa2, "auroraRodrigues", "senha123@");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        //Act
        boolean resultado = usuarios.get(0).hashCode() == usuarios.get(1).hashCode();
        
        //Assert
        assertFalse(resultado);
    }
    
     @Test
    public void testaAIgualdadeDeObjetosDoTipoUsuarioPeloCpfComOContains(){
        //Arrange
        Pessoa pessoa = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Usuario usuario1 = new Usuario(pessoa, "Aurora", "Senha123@");
        Usuario usuario2 = new Usuario(pessoa, "auroraRodrigues", "Senha123");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        
        //Act
        boolean resultado = usuarios.contains(usuario2);
        
        //Assert
        assertTrue(resultado);
    }
    
    @Test
    public void testaADiferencaDeObjetosDoTipoUsuarioPeloCpfComContains(){
        //Arrange
        Pessoa pessoa1 = new Pessoa("12345678909", "Aurora Rodrigues", "23/01", "F");
        Pessoa pessoa2 = new Pessoa("12345678908", "Aurora Rodrigues", "28/05", "F");
        
        Usuario usuario1 = new Usuario(pessoa1, "Aurora", "Senha123");
        Usuario usuario2 = new Usuario(pessoa2, "auroraRodrigues", "senha123@");
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        
        //Act
        boolean resultado = usuarios.contains(usuario2);
        
        //Assert
        assertFalse(resultado);
    }
}
