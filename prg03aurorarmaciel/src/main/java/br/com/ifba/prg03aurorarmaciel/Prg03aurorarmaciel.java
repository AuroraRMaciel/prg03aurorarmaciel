/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba.prg03aurorarmaciel;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.coletor.entity.Coletor;
import br.com.ifba.perfil.entity.Perfil;
import br.com.ifba.produtor.entity.ProdutorDerivados;
import br.com.ifba.transportador.entity.Transportador;
import br.com.ifba.usuario.entity.Usuario;

/**
 *
 * @author auror
 */
public class Prg03aurorarmaciel {

    public static void main(String[] args) {
        //Task 02
        Usuario usuario1 = new Usuario("aurora", "senha123");
        Usuario usuario2 = new Usuario("Aurora", "12345");
        
        if (usuario1.autenticar("aurora", "senha123")){
            System.out.println("Autenticado com sucesso\n");
        }
        
        if (usuario2.autenticar("Aurora", "12345")){
            System.out.println("Autenticado com sucesso\n");
        }
        
        Cliente cliente = new Cliente();
        Coletor coletor = new Coletor();
        Transportador logistica = new Transportador();
        ProdutorDerivados produtor = new ProdutorDerivados();
        
        Perfil coleta = new Coletor();
        Perfil producao = new ProdutorDerivados();
        Perfil transporte = new Transportador();
        Perfil compra = new Cliente();
        
        System.out.println(cliente.getTipoPerfil());
        System.out.println(coletor.getTipoPerfil());
        System.out.println(logistica.getTipoPerfil());
        System.out.println(produtor.getTipoPerfil() + "\n");
        
        System.out.println(coleta.getTipoPerfil());
        System.out.println(producao.getTipoPerfil());
        System.out.println(transporte.getTipoPerfil());
        System.out.println(compra.getTipoPerfil());
    }
}
