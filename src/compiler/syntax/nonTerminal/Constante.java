package compiler.syntax.nonTerminal;

public class Constante extends NonTerminal {

	private int value;
	private String nombre;
	
	public Constante () {
		super();
	}
		
	public Constante(String nombre, int value) {
		this();
		this.value=value;
		this.nombre=nombre;
	}
	
	public int getValue(){
		return value;
	}
	/*
	public void setValue(int valor){
		this.valor=valor;
	}*/	
	public String getName(){
		return nombre;
	}
	public String toString() {
		return nombre;
	}
}