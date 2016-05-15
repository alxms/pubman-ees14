package com.ees14.entity;

public enum Alcance {
	INTERNACIONAL ("Internacional"),
	NACIONAL ("Nacional");
	
	private Alcance(String value){
        this.value = value;
    }

    private final String value;

    public String getValue(){return value;}
}
