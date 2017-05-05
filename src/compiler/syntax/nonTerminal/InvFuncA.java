package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class InvFuncA extends NonTerminal {

	private ArrayList<Expresion> lista;
	private int numeroParametros;
	
	public InvFuncA () {
		super();
		lista= new ArrayList<Expresion>();
	}
	
	public InvFuncA (Expresion exp) {
		this();
		this.lista.add(exp);
		numeroParametros=1;
		
	}
	public void add(Expresion exp) {
		this.lista.add(exp);
		numeroParametros++;
	}
	public int getNumberOfParameters(){
		return numeroParametros;
	}
	public ArrayList<Expresion> getParameters(){
		return lista;
	}

}
