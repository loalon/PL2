package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class Grupos<T> extends NonTerminal {

	private ArrayList<T> lista;
	
    public Grupos () {
        super (); 
		this.lista= new ArrayList<T>();
    }
	public Grupos (T t) {
		this();
		this.lista.add(t);
	}
    public void setLista(ArrayList<T> lista) {
    	this.lista=lista;
    }
    public ArrayList<T> getLista() {
    	return lista;
    }
    public void add(T t) {
    	this.lista.add(t);
    }
}
