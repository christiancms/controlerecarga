/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.dao;

import br.com.recarga.bean.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Maicon
 */
public class DAOUsuario {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ControleRecargaPU");
        return factory.createEntityManager();
    }

    public Usuario salvar(Usuario usuario) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (usuario.getIdUsuario() == null) {
                em.persist(usuario); // executa insert
            } else {
                if (!em.contains(usuario)) {
                    if (em.find(Usuario.class, usuario.getIdUsuario()) == null) {
                        throw new Exception("Erro ao atualizar o usuário");
                    }
                }
                usuario = em.merge(usuario); // executa update
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return usuario;
    }

    public void remover(Long id) {

        EntityManager em = getEM();
        Usuario usuario = em.find(Usuario.class, id);
        try {
            em.getTransaction().begin();
            em.remove(usuario);  // executa delete
            em.getTransaction().commit();
        } finally {
            em.close();

        }
    }

    public List<Usuario> listar() {
        EntityManager em = getEM();
        Query q = em.createQuery("SELECT u FROM Usuario u");
        return q.getResultList();
    }

    public Usuario consultarPorId(Long id) {
        EntityManager em = getEM();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id); // executa select
        } finally {
            em.close();
        }
        return usuario;
    }

    public boolean verificaLogin(String user, String password, boolean tag) {
        if (tag == true && user.equals("admin") && password.equals("aa1bf4646de67fd9086cf6c79007026c")) {
            return true;
        } else {
            EntityManager em = getEM();
            em.getTransaction().begin();
            Query qparam = em.createNativeQuery("SELECT nomeusuario, senha FROM usuario "
                    + "WHERE nomeusuario = ? AND senha = ?");
            qparam.setParameter(1, user);
            qparam.setParameter(2, password);
            int resultado = qparam.getResultList().size();
            return resultado > 0;
        }
    }
}

//Query query = em.createNativeQuery("SELECT * FROM EMPLOYEE WHERE F_NAME = ? AND L_NAME = ?", Employee.class);
//query.setParameter(1, "Bob");
//query.setParameter(2, "Smith");
//List<Employee> result = query.getResultList();

