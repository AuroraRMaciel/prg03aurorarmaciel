/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author auror
 */
public class JPAUtil {
    
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("gerenciamento_banco_dados_ecocaatinga");//Criada uma única vez: é cara de construir
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
        //cada chamada devolve um novo, para ser fechado por quem usou
    }
}
