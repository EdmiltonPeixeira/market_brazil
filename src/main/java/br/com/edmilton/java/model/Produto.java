package br.com.edmilton.java.model;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	private String imagem;
	
	@Column
	private String descricao;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getImagem() {
		return imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
