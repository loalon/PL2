package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class CamporegB extends NonTerminal {

	private TypeIF tipo=null;; //tipo de la lista de variables
	private ArrayList<String> lista;
	
	public CamporegB (String nombre, TypeIF tipo) {
		super();
		this.tipo=tipo;
		this.lista=new ArrayList<String>();
		this.lista.add(nombre);
	}
	
	public CamporegB (String nombre, TypeIF tipo, ArrayList<String> lista) {
		this(nombre, tipo);
		//this.tipo=tipo;
		this.lista=lista;
		//this.lista.add(nombre);
	}
	public TypeIF getType(){
		return tipo;
	}
	public void setType(TypeIF tipo){
		this.tipo=tipo;
	}
		
	public ArrayList<String> getVariables(){
		return lista;
	}
	public void addVariable(String var){
		this.lista.add(var);
	}

	//public get ()
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
