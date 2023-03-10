package com.models;

public class Bevanda {

	private Integer bevandaID;
	private String nome;
	private String descrizione;
	private Float gradoAlcolico;

	public Bevanda() {
	}

	public Bevanda(Integer bevandaID, String nome, String descrizione, Float gradoAlcolico) {
		super();
		this.bevandaID = bevandaID;
		this.nome = nome;
		this.descrizione = descrizione;
		this.gradoAlcolico = gradoAlcolico;
	}

	public Integer getBevandaID() {
		return bevandaID;
	}

	public void setBevandaID(Integer bevandaID) {
		this.bevandaID = bevandaID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getGradoAlcolico() {
		return gradoAlcolico;
	}

	public void setGradoAlcolico(Float gradoAlcolico) {
		this.gradoAlcolico = gradoAlcolico;
	}

}
