/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author auror
 */
public class RepositorioUsuarioEmMemoria {
    //Atributos
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<String, Usuario> porLogin = new HashMap<>();

    //Métodos
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<String, Usuario> getPorLogin() {
        return porLogin;
    }
    
    public void cadastrarUsuario(Usuario usuario){
        //Verificar se o login utilizado já está cadastrado
        if (porLogin.get(usuario.getLogin()) != null){
            throw new IllegalArgumentException("Já existe um usuário com o login " + usuario.getLogin());
        }
        else{
            this.porLogin.put(usuario.getLogin(), usuario);//Alimenta o map a cada cadastro
            this.usuarios.add(usuario);
        }
    }
    
    public List<Usuario> listarTodos(){
        return usuarios;
    }
    
    public Usuario buscarPorLogin(String login){
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getLogin().equalsIgnoreCase(login)){
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    public Usuario buscaPorLogin(String login){
        Usuario usuario = porLogin.get(login);
        
        return usuario;
    }
}
