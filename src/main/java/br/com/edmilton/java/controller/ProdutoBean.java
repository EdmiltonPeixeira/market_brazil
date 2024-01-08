package br.com.edmilton.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.edmilton.java.dao.ProdutoDAO;
import br.com.edmilton.java.model.Produto;

@ManagedBean (name = "produtoBean")
@RequestScoped
public class ProdutoBean {
	public List<Produto> consultarTodos(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.consultarProdutos();
	}
}
