package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Funcion extends NonTerminal {

	private TypeIF tipo=null;
	private String nombre;
	private ArrayList<String> listaParametros;
	private int numeroParametros=0;
	
	public Funcion () {
		super();
		this.listaParametros = new ArrayList<String>();
	}
	public Funcion (String nombre, TypeIF tipo) {
		this();
		this.tipo=tipo;
		this.nombre=nombre;
	}
	public Funcion (String nombre, TypeIF tipo, FuncionE parametros) {
		this(nombre,tipo);
		this.listaParametros=parametros.getParametros();
		this.numeroParametros=parametros.getNumeroParametros();
	}
	
	public String getNombre () {
		return nombre;
	}
	public TypeIF getTipo () {
		return tipo;
	}	
	public ArrayList<String> getParametros () {
		return listaParametros;
	}	
	public int getNumeroParametros () {
		return numeroParametros;
	}	

}
