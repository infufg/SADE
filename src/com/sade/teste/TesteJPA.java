package com.sade.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eurismar Pires Borges
 */
public class TesteJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SADEPU");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();
    }
}
