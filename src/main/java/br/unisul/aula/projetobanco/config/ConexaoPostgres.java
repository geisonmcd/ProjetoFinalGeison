package br.unisul.aula.projetobanco.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ConexaoPostgres {

    private EntityManagerFactory entityManager;

    /* Singleton */
    private static ConexaoPostgres instancia = new ConexaoPostgres();

    private ConexaoPostgres(){}

    public static ConexaoPostgres getInstancia(){
        return instancia;
    }
    /* **** */

    public EntityManager getEntityManager(){
        if (entityManager==null){
            entityManager = Persistence.createEntityManagerFactory("banco");
        }
        return entityManager.createEntityManager();
    }
}
