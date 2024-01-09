package br.com.edmilton.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Dao<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4387884197189233927L;
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("PERSISTENCE");
	}
	
	public void salvar(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			t = em.merge(t);
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void excluir(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			t = em.merge(t);
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void editar(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public abstract List lista();

}
