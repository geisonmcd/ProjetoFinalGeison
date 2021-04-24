package br.unisul.aula.projetobanco.config;

import javax.persistence.NoResultException;
import java.util.List;

public interface CrudBasico<E> {

    List<E> listarTodos();
    void adicionarUm(E dado);
    E bucarObjetoPorNome(String nomeBuscado) throws IllegalArgumentException, NoResultException;
}
