/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.operations;

import com.application.models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredwinrosales
 */
public class UserOP {
    
    private EntityManager manager;
    private EntityManagerFactory emf; 
    private User e;

    public UserOP(
                Long id, 
                String name, 
                String email,
                String password
    ) {
        emf = Persistence.createEntityManagerFactory("Persistencia");
        e = new User(
                id, 
                name, 
                email, 
                password
        );
    }
    
    public void create(){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        
    }
    
    public void doGet(){
        List<User> users = 
                (List<User>) manager.createQuery(
                        "FROM User"
                ).getResultList();
        
        System.out.println("****");
        System.out.println(" ");
        
        System.out.println(
                "Hay  "+ users.size() + " usuarios en el sistema."
        );
        for(User user : users){
            System.out.println(user.toString());   
        }
        
        System.out.println(" ");
        System.out.println("****");
        
    }
    
    public void closeConnection(){
        emf.close();
    }
    
}
