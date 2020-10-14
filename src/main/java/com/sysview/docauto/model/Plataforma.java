package com.sysview.docauto.model;

public class Plataforma {
    
    private String plataformaId;
    private String sistemaId;
    private String claseId;
    private String biblitoecaId;
    
    public String getBiblitoecaId() {
		return biblitoecaId;
	}

	public void setBiblitoecaId(String biblitoecaId) {
		this.biblitoecaId = biblitoecaId;
	}

	public String getSistemaId() {
		return sistemaId;
	}

	public String getClaseId() {
		return claseId;
	}

	public Plataforma(String plataformaId) {
        this.plataformaId = plataformaId;
    }

	public String getPlataformaId() {
        return plataformaId;
    }
    
    public void setPlataformaId(String plataformaId) {
        this.plataformaId = plataformaId;
    }

	public void setSistemaId(String sistemaId) {
		this.plataformaId= sistemaId;
	}

	public void setClaseId(String claseId) {
		this.plataformaId=claseId;
	}

	public void setBibliotecaId(String string) {
		this.setBibliotecaId(string);
	}
}
