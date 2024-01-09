package br.com.edmilton.java.controller;

import java.io.Serializable;

public abstract class Bean implements Serializable {
	
	public abstract void salvar();

	public abstract void editar();

	public abstract void excluir();

}
