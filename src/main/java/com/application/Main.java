package com.application;

import com.application.models.Empleado;
import com.application.models.Post;
import com.application.models.User;
import com.application.operations.EmpleadoOP;
import com.application.operations.PostOP;
import com.application.operations.UserOP;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredwinrosales <fredwinrosales@gmail.com>
 */
public class Main {
    
    public static void main(String[] args){
        
        // Example 1
        
//        EmpleadoOP empleadoOP = new EmpleadoOP(
//                2L, 
//                "Campos", 
//                "Youseli", 
//                new GregorianCalendar(1984, 7, 25).getTime()
//        );
//        empleadoOP.create();
//        empleadoOP.doGet();
//        empleadoOP.closeConnection();
        
        // Example 2
        UserOP userOP = new UserOP(
                    2L, 
                    "Fredwin", 
                    "fredwinrosales@gmail.com", 
                    "1234"
            );
        try{
            userOP.create();
            userOP.doGet();
        } finally {
            userOP.closeConnection();
        }
        
//        EntityManager manager;
//        EntityManagerFactory emf; 
//        
//        emf = Persistence.createEntityManagerFactory("Persistencia");
//        manager = emf.createEntityManager();
//        
//	manager.getTransaction().begin();
//
//	User user = new User();
//        user.setId(1L);
//        user.setName("Fredwin");
//        user.setEmail("fredwinrosales@gmail.com");
//        user.setPassword("1234");
//        manager.persist(user);
//
//        Post post = new Post();
//        post.setId(1L);
//        post.setTitle("La constituyente");
//        post.setContent(
//                "Fraude electoral mas grande de la historia de Venezuela"
//        );
//        post.setUser(user);
//        manager.persist(post);
//
//	manager.getTransaction().commit();
//        
//        PostOP postOP = new PostOP();
//        
//        try{
//            postOP.doGet();
//        } finally {
//            userOP.closeConnection();
//        }
//        
//        manager.close();
//        emf.close();
        
	System.out.println("Done");
        
    }
            
}
