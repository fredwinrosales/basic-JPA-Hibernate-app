/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.operations;

import com.application.models.Post;
import com.application.models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredwinrosales
 */
public class PostOP {
    
    private EntityManager manager;
    private EntityManagerFactory emf; 
    private User e;

    public PostOP(){
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
    }
    
    public PostOP(
                Long id, 
                String name, 
                String email,
                String password
    ) {
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
        e = new User(
                id, 
                name, 
                email, 
                password
        );
    }
    
    public void create(){
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        
    }
    
    public void doGet(){
        List<Post> posts = 
                (List<Post>) manager.createQuery(
                        "FROM Post"
                ).getResultList();
        
        System.out.println("****");
        System.out.println(" ");
        
        System.out.println(
                "Hay  "+ posts.size() + " posts en el sistema."
        );
        for(Post post : posts){
            System.out.println(post.toString());   
        }
        
        System.out.println(" ");
        System.out.println("****");
        
    }
    
    public void closeConnection(){
        emf.close();
    }
    
}
