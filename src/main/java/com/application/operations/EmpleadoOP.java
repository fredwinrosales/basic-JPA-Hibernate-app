/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.operations;

import com.application.models.Empleado;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredwinrosales <fredwinrosales@gmail.com>
 */
public class EmpleadoOP {

    private EntityManager manager;
    private EntityManagerFactory emf; 
    private Empleado e;
    
    public EmpleadoOP(
                Long codigo, 
                String apellidos, 
                String nombres, 
                Date fechaNacimiento
        ){
        emf = Persistence.createEntityManagerFactory("Persistencia");
        e = new Empleado(
                codigo, 
                apellidos, 
                nombres, 
                fechaNacimiento
        );
    }
    
    public void create(){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        
    }
    
    public void doGet(){
        List<Empleado> empleados = 
                (List<Empleado>) manager.createQuery(
                        "FROM Empleado"
                ).getResultList();
        System.out.println(
                "Hay  "+ empleados.size() + " empleados en el sistema."
        );
        for(Empleado emp : empleados){
            System.out.println(emp.toString());   
        }
    }
    
    public void closeConnection(){
        emf.close();
    }
}
