package br.com.edmilton.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.edmilton.java.model.JPAUtil;
import br.com.edmilton.java.model.Produto;

public class ProdutoDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void salvar(Produto produto) {
		entity.getTransaction().begin();
		entity.persist(produto);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}
	
	public Produto consultar(int id) {
		Produto produto = new Produto();
		produto = entity.find(Produto.class, id);
		JPAUtil.shutdown();
		return produto;
	}
	
	public void editar(Produto produto) {
		entity.getTransaction().begin();
		entity.merge(produto);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}
	
	public List<Produto> consultarProdutos(){
		List<Produto> produtos = new ArrayList<>();
		Query query = entity.createQuery("SELECT * FROM PRODUTOS ");
		produtos = query.getResultList();
		return produtos;
	}
}
