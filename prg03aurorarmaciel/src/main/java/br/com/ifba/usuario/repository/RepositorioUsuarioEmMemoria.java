/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author auror
 */
public class RepositorioUsuarioEmMemoria {
    //Atributos
    private final List<Usuario> usuarios = new ArrayList<>();
    
    //Métodos
    public void cadastrarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    
    public List<Usuario> listarTodos(){
        return usuarios;
    }
}
