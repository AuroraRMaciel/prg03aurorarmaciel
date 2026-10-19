/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;
import br.com.ifba.usuario.interfaces.Autenticavel;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.status.model.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author auror
 */
@Entity
@Table (name = "usuarios")
public class Usuario implements Autenticavel{
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Adicione a anotação de relacionamento (@OneToOne ou @ManyToOne)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id") // Nome da coluna correspondente no banco
    private Pessoa pessoa;
    // Informe ao Hibernate que é um relacionamento entre entidades
    @OneToMany
    @JoinColumn(name = "perfis_id") // Nome da coluna de chave estrangeira no banco
    private List<Perfil> perfis;
    // Informe ao Hibernate que é um relacionamento entre entidades
    @ManyToOne
    @JoinColumn(name = "perfil_ativo_id") // Nome da coluna de chave estrangeira no banco
    private Perfil perfilAtivo;
    private Status status;
    
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;
    private String telefone;
    
    private String email;
    private String login;
    private String senha;
    
    @Column (name = "criado_em")
    private LocalDateTime criadoEm;
    
    @Column (name = "ultimo_login")
    private LocalDateTime ultimoLogin;
    private String endereco;
    
    //Métodos
    public Usuario(){
        
    }
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.status = Status.INATIVO;
        this.criadoEm = LocalDateTime.now();
    }
    public Usuario(Pessoa pessoa, String login, String senha){
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.status = Status.INATIVO;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    
    public Pessoa getPessoa(){
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    
    public List<Perfil> getPerfis(){
        return perfis;
    }
    public void setPerfis(List<Perfil> perfis){
        this.perfis = perfis;
    }
    
    public Perfil getPerfilAtivo(){
        return perfilAtivo;
    }
    public void setPerfilAtivo(Perfil perfilAtivo){
        this.perfilAtivo = perfilAtivo;
    }
    
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public LocalDateTime getCriadoEm(){
        return criadoEm;
    }
    public void setCriadoEm(LocalDateTime criadoEm){
        this.criadoEm = criadoEm;
    }
    
    public LocalDateTime getUltimoLogin(){
        return ultimoLogin;
    }
    public void setUltimoLogin(LocalDateTime ultimoLogin){
        this.ultimoLogin = ultimoLogin;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    /*private boolean senhaValida(String senha){
        return this.senha.equals(senha);
    }*/
    
    @Override
    public boolean autenticar(String login, String senha){
        /*if (this.login.equals(login) && this.senha.equals(senha)){
            return true;
        }
        else{
            return false;
        }*/
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    public void adicionarPerfilALista(Perfil perfil){
        this.perfis.add(perfil);
    }

    //Task 02
    //Escolhi o cpf pois é único e identifica bem um usuario
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Usuario usuario = (Usuario) o;
        
        if (pessoa.getCpf() != null){
            return pessoa.getCpf().equals(usuario.pessoa.getCpf());
        }else{
            return usuario.pessoa.getCpf() == null;
        }
    }
    
    @Override
    public int hashCode(){
        if (pessoa.getCpf() != null){
            return pessoa.getCpf().hashCode();
        }else{
            return 0;
        }
    }
}
