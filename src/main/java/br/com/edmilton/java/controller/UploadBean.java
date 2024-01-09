package br.com.edmilton.java.controller;

import org.primefaces.model.UploadedFile;

public class UploadBean {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
