package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class BloqueSent extends NonTerminal {

	private ArrayList<Tipo> listaTipo;
	private ArrayList<VariableA> listaVariables;
	private ArrayList<Sentencia> listaSentencias;
	
	public BloqueSent() {
		super();
	}
	// eliminar===
	public BloqueSent (ArrayList<Tipo> listaTipo, ArrayList<VariableA> listaVariables, ArrayList<Sentencia> listaSentencias) {
		this();
		this.listaTipo=listaTipo;
		this.listaVariables=listaVariables;
		this.listaSentencias=listaSentencias;
	}

	public ArrayList<Tipo> getTipos() {
		return listaTipo;
	}	
	public ArrayList<VariableA> getVariables() {
		return listaVariables;
	}	
	public ArrayList<Sentencia> getSentencias()	{
		return listaSentencias;
	}	
}
