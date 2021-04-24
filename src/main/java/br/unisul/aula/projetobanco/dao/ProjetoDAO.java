package br.unisul.aula.projetobanco.dao;

import br.unisul.aula.projetobanco.config.ConexaoPostgres;
import br.unisul.aula.projetobanco.config.ConstantesNavegacao;
import br.unisul.aula.projetobanco.config.CrudBasico;
import br.unisul.aula.projetobanco.model.Projeto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


public class ProjetoDAO implements CrudBasico<Projeto> {

    private final EntityManager entityManager;

    public ProjetoDAO(){
        entityManager = ConexaoPostgres.getInstancia().getEntityManager();
    }

    @Override
    public List<Projeto> listarTodos() {
        return entityManager.createQuery("SELECT P FROM Projeto P").getResultList();
    }

    @Override
    public void adicionarUm(Projeto dado) {
        entityManager.getTransaction().begin();
        entityManager.persist(dado);
        entityManager.getTransaction().commit();
    }

    @Override
    public Projeto bucarObjetoPorNome(String nomeBuscado) throws IllegalArgumentException, NoResultException {
        Query query = entityManager.createQuery("SELECT P FROM Projeto P WHERE P.nome=:nomeDaBusca");
        query.setParameter("nomeDaBusca", nomeBuscado);
        Object object = query.getSingleResult();
        if (object instanceof Projeto) {
            Projeto projeto = (Projeto) object;
            return projeto;
        }
        throw new IllegalArgumentException(ConstantesNavegacao.MENSAGEM_PROJETO_NAO_ENCONTRADA);
    }
}
