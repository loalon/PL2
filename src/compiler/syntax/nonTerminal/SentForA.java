package compiler.syntax.nonTerminal;

import java.util.List;

import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class SentForA extends NonTerminal {
	
	private Variable vari;
	private ExpLog from;
	private Expresion to;
	private Expresion inc;
	
	//private List<QuadrupleIF> from;
	//private List<QuadrupleIF>  to;
	//private List<QuadrupleIF>  inc;
	
	
	public SentForA () {
		super();
	}
	
	public SentForA (Variable vari, ExpLog from, Expresion to, Expresion inc) {
		this();
		this.vari=vari;
		this.from=from;
		this.to=to;
		this.inc=inc;
	}
	public Variable getVariable(){
		return vari;
	}
	public ExpLog getFrom(){
		return from;
	}
	public Expresion getTo(){
		return to;
	}
	public Expresion getInc(){
		return inc;
	}
}
