package br.com.edmilton.java.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.edmilton.java.dao.ProdutoDao;
import br.com.edmilton.java.model.Produto;

import java.util.Map;

@ManagedBean (name = "produtoBean")
@ViewScoped
public class ProdutoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8958178633452066035L;
	private ProdutoDao produtoDao;
	private List<Produto> listaProdutos;
	
	public ProdutoBean() {
		this.produtoDao = new ProdutoDao();
		this.listaProdutos = new ArrayList<>();
	}
	
	public String cadastrar() {
		Produto produto = new Produto();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("produto", produto);
		return "/cadastro.xhtml?faces-redirect=true";
	}
	
	public String salvar(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.salvar(produto);
		return "/produtosCadastrados.xhtml?faces-redirect=true";
	}
	
	public String editar(Produto produto) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("produto", produto);
		return "/editar.xhtml?faces-redirect=true";
	}
	
	public String atualizar(Produto produto) {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.editar(produto);
		return "/produtosCadastrados.xhtml?faces-redirect=true";
	}
	
	public String excluir(Produto p) {
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.excluir(p);
		return "/produtosCadastrados.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public List<Produto> getProdutos() {
		listaProdutos = produtoDao.lista();
		return listaProdutos;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDAO(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
}
