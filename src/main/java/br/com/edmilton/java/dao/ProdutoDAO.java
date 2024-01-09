package br.com.edmilton.java.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.edmilton.java.model.Produto;

public class ProdutoDao extends Dao<Produto> implements Serializable{
	
	public Produto findProduto(Integer id) {
		EntityManager em = emf.createEntityManager();
		try {
			Produto produto = (Produto) em.createQuery("SELECT p from PRODUTOS p where p.id = '" + id + "'").getSingleResult();
			return produto;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Produto> findById(Integer id){
		EntityManager em = emf.createEntityManager();
		try {
			List<Produto> list = em.createQuery("SELECT p from PRODUTOS p where p.id = '" + id + "'").getResultList();
			return list;
		} catch (Exception e) {
			return null;
		} 
	}

	@Override
	public List<Produto> lista() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Produto> query = (TypedQuery<Produto>) em.createNativeQuery("SELECT * FROM PRODUTOS", Produto.class);
			List<Produto> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
