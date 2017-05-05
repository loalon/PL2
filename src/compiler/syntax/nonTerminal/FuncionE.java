package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class FuncionE extends NonTerminal {

	private ArrayList<String> lista;
	//private int offset;
	
	public FuncionE () {
		super();
		this.lista=new ArrayList<String>();
	}
	public FuncionE (String param) {
		this();
		this.lista.add(param);
		//this.numeroParametros=1;
	}
	
	public void add(String param) {
		this.lista.add(param);
		//this.numeroParametros++;
	}
	public ArrayList<String> getParameters() {
		return lista;
	}	
	/*
	public int getNumeroParametros() {
		return lista.size();
	}*/
}
