package com.ees14.entity;

public enum Status {

	PENDENTE ("Pendente"),
	ACEITO ("Aceito"),
	PUBLICADO ("Publicado");
	
	private Status(String value){
        this.value = value;
    }

    private final String value;

    public String getValue(){return value;}
}
