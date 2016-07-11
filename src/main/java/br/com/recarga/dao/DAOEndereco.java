/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.dao;

import br.com.recarga.bean.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Maicon
 */
public class DAOEndereco {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleRecargaPU");
        return factory.createEntityManager();
    }

    public Endereco salvar(Endereco endereco) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (endereco.getIdEndereco() == null) {
                em.persist(endereco); // executa insert
            } else {
                if (!em.contains(endereco)) {
                    if (em.find(Endereco.class, endereco.getIdEndereco()) == null) {
                        throw new Exception("Erro ao atualizar a endereco");
                    }
                }
                endereco = em.merge(endereco); // executa update
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return endereco;
    }

    public void remover(Long id) {

        EntityManager em = getEM();
        Endereco endereco = em.find(Endereco.class, id);
        try {
            em.getTransaction().begin();
            em.remove(endereco);  // executa delete
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }

    public List<Endereco> listar() {
        EntityManager em = getEM();
        Query q = em.createQuery("SELECT e FROM Endereco e");
        return q.getResultList();
    }

    public Endereco consultarPorId(Long id) {
        EntityManager em = getEM();
        Endereco endereco = null;
        try {
            endereco = em.find(Endereco.class, id); // executa select
        } finally {
            em.close();
        }
        return endereco;
    }

    public List<Endereco> consultarPorPessoaId(Long id) {
        EntityManager em = getEM();
        Query qparam = em.createNativeQuery("SELECT * FROM pessoa "
                + "as p inner join endereco as e on p.pessoa_id=e.id_pessoa  WHERE "
                + "e.id_pessoa = ?");
        qparam.setParameter(1, id);
        return qparam.getResultList();
    }
}
