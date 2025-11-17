package com.projetosoftwareteusz.config;

public enum ConfiguracaoSistema {

	INSTANCIA;

	private String nomeLoja;
	private double taxaDescontoGlobal; // 0.10 = 10%

	ConfiguracaoSistema() {
		this.nomeLoja = "Loja Teusz";
		this.taxaDescontoGlobal = 0.10;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public double getTaxaDescontoGlobal() {
		return taxaDescontoGlobal;
	}

	public void setTaxaDescontoGlobal(double taxaDescontoGlobal) {
		this.taxaDescontoGlobal = taxaDescontoGlobal;
	}
}
