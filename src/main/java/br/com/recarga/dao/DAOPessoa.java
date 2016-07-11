
package br.com.recarga.dao;

import br.com.recarga.bean.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Maicon
 */
public class DAOPessoa {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleRecargaPU");
        return factory.createEntityManager();
    }

    public Pessoa salvar(Pessoa pessoa) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (pessoa.getIdPessoa()== null) {
                em.persist(pessoa); // executa insert
                em.flush();
                em.refresh(pessoa);
                Pessoa id = em.find(Pessoa.class, pessoa.getIdPessoa());
            } else {
                if (!em.contains(pessoa)) {
                    if (em.find(Pessoa.class, pessoa.getIdPessoa()) == null) {
                        throw new Exception("Erro ao atualizar a pessoa");
                    }
                }
                pessoa = em.merge(pessoa); // executa update
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            
        }
        return pessoa;
    }
    
    
    
    public void remover(Long id) {

        EntityManager em = getEM();
        Pessoa pessoa = em.find(Pessoa.class, id);
        try {
            em.getTransaction().begin();
            em.remove(pessoa);  // executa delete
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }
    
    public List<Pessoa> listar() {
        EntityManager em = getEM();
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        return q.getResultList();
    }

    public Pessoa consultarPorId(Long id) {
        EntityManager em = getEM();
        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, id); // executa select
        } finally {
            em.close();
        }
        return pessoa;
    }
}
