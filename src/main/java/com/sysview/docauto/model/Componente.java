package com.sysview.docauto.model;

public class Componente {
	
	private String plataformaID;
	private String sistemaID;
	private String claseId;
	private String bibliotecaId;
	private String componente;
	private String productoId;
	private String formatoId;
	private byte[] docto;
    private String format;
    private String descripcion;
	
	public String getPlataformaID() {
		return plataformaID;
	}
	public void setPlataformaID(String plataformaID) {
		this.plataformaID = plataformaID;
	}
	public String getSistemaID() {
		return sistemaID;
	}
	public void setSistemaID(String sistemaID) {
		this.sistemaID = sistemaID;
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
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	public String getProductoId() {
		return productoId;
	}
	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}
	
	public String getFormatoId() {
		return formatoId;
	}
	public void setFormatoId(String formatoId) {
		this.formatoId = formatoId;
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	public byte[] getDocto() {
		return docto;
	}
	public void setDocto(byte[] docto) {
		this.docto = docto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
		
	}
}
