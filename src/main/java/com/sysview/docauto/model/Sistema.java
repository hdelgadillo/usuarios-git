package com.sysview.docauto.model;

public class Sistema {
	private String sistemaId;
	private String plataformaId;
	private String claseId;
	private String bibliotecaId;
	
	public Sistema (String sistemaId){
		this.sistemaId = sistemaId;
	}

	public String getSistemaId() {
		return sistemaId;
	}

	public void setSistemaId(String sistemaId) {
		this.sistemaId = sistemaId;
	}
//

	public String getPlataformaId() {
		return plataformaId;
	}

	public void setPlataformaId(String plataformaId) {
		this.plataformaId = plataformaId;
	}

	public String getClaseId() {
		return claseId;
	}

	public void setClaseId(String claseId) {
		this.claseId = claseId;
	}

	public String getBibliotecaId() {
		return bibliotecaId;
	}

	public void setBibliotecaId(String bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}
	


}
