package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Tipo extends NonTerminal {

	private TypeIF tipo=null;
	private String nombre;
		
	public Tipo(String nombre, TypeIF tipo) {
		super();
		this.tipo=tipo;
		this.nombre=nombre;
	}
	public TypeIF getTipo(){
		return tipo;
	}
	public String getNombre(){
		return nombre;
	}
	public void setTipo(TypeIF tipo){
		this.tipo=tipo;
	}	
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String toString(){
		return nombre;
	}
}
