package br.unisul.aula.projetobanco.dao;

import br.unisul.aula.projetobanco.config.ConexaoPostgres;
import br.unisul.aula.projetobanco.config.ConstantesNavegacao;
import br.unisul.aula.projetobanco.config.CrudBasico;
import br.unisul.aula.projetobanco.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements CrudBasico<Usuario> {
    private final EntityManager entityManager;

    public PessoaDAO() {
        entityManager = ConexaoPostgres.getInstancia().getEntityManager();
    }

    @Override
    public List<Usuario> listarTodos() {
        return entityManager.createQuery("SELECT U FROM Usuario U", Usuario.class).getResultList();
    }

    @Override
    public void adicionarUm(Usuario dado) {
        entityManager.getTransaction().begin();
        entityManager.persist(dado);
        entityManager.getTransaction().commit();

    }

    @Override
    public Usuario bucarObjetoPorNome(String nomeBuscado) throws IllegalArgumentException, NoResultException {
        Query query = entityManager.createQuery("SELECT U FROM Usuario U WHERE U.nome=:nomeDaBusca");
        query.setParameter("nomeDaBusca", nomeBuscado);
        Object object = query.getSingleResult();
        if (object instanceof Usuario) {
            Usuario pess = (Usuario) object;
            return pess;
        }
        throw new IllegalArgumentException(ConstantesNavegacao.MENSAGEM_PESSOA_NAO_ENCONTRADA);
    }
}
