/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

/**
 *
 * @author umita
 */
public class Populate {
     public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "seedMavenP" );
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        User u = new User("test", "test");
        PasswordStorage.createHash("test");
        em.persist(u);
        
        
        em.getTransaction().commit();
        em.close();
    }
}
