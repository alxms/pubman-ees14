package com.ees14.entity;

public enum Tipo {
	PERIODICO ("Periodico"),
	CONFERENCIA ("Conferencia"),
	LIVRO_COMPLETO ("Livro Completo"),
	CAPITULO_LIVRO ("Capitulo de Livro");
	
	private Tipo(String value){
        this.value = value;
    }

    private final String value;

    public String getValue(){return value;}
}
