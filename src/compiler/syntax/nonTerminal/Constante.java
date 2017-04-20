package compiler.syntax.nonTerminal;

public class Constante extends NonTerminal {

	private int valor;
	private String nombre;
	
	// no tengo claro su utilidad
	public Constante () {
		super();
	}
		
	public Constante(String nombre, int valor) {
		this();
		this.valor=valor;
		this.nombre=nombre;
	}
	
	public int getValor(){
		return valor;
	}
	public void setValor(int valor){
		this.valor=valor;
	}	
	public String getNombre(){
		return nombre;
	}
	public String toString() {
		return nombre;
	}
}

	
	//long hascode()
	//boolean equals (Object o)
	// public String toString() 