package br.com.recarga.dao;

import br.com.recarga.bean.OrdemServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Maicon
 */
public class DAOServico {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleRecargaPU");
        return factory.createEntityManager();
    }

    public OrdemServico salvar(OrdemServico servico) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (servico.getIdOrdServico() == null) {
                em.persist(servico);
            } else {
                if (!em.contains(servico)) {
                    if (em.find(OrdemServico.class, servico.getIdOrdServico()) == null) {
                        throw new Exception("Erro ao atualizar o servico");
                    }

                }
                servico = em.merge(servico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return servico;
    }
    
    public List<OrdemServico> listar() {
        EntityManager em = getEM();
        Query q = em.createQuery("SELECT o FROM OrdemServico o");
        return q.getResultList();
    }
    
    public OrdemServico consultarPorId(Long id) {
        EntityManager em = getEM();
        OrdemServico servico = null;
        try {
            servico = em.find(OrdemServico.class, id); // executa select
        } finally {
            em.close();
        }
        return servico;
    }
    
}
