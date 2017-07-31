package tests;

import basic.jpa.hibernate.modelo.Empleado;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredwinrosales <fredwinrosales@gmail.com>
 */
public class TestEmpleados {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;
    
    public static void main(String[] args){
        
        emf = Persistence.createEntityManagerFactory("Oracle");
        
        manager = emf.createEntityManager();
        
        Empleado e = new Empleado(25L, "Campos", "Youseli", new GregorianCalendar(1984, 7, 25).getTime());
        
        manager.getTransaction().begin();
        
        manager.persist(e);
        
        manager.getTransaction().commit();
        
        imprimirTodo();
        
    }
    
    private static void imprimirTodo(){
        
        List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        
        System.out.println("Hay  "+ empleados.size() + " empleados en el sistema.");
        
        for(Empleado emp : empleados){
            
            System.out.println(emp.toString());
            
        }
        
    }
            
}
