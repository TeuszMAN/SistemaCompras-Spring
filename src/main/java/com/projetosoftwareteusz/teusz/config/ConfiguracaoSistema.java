package com.projetosoftwareteusz.teusz.config;

public enum ConfiguracaoSistema {

	INSTANCIA;

	private final String nomeLoja=  "Teusz Store";
	private final double taxaDescontoGlobal = 0;


	public String getNomeLoja() {
		return nomeLoja;
	}

	public double getTaxaDescontoGlobal() {
		return taxaDescontoGlobal;
	}

}
