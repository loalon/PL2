package compiler.syntax.nonTerminal;

import compiler.semantic.symbol.SymbolVariable;

public class SentForA extends NonTerminal {
	
	private SymbolVariable vari;
	private ExpLog from;
	private Expresion to;
	private Expresion inc;
	int offset=0;
	
	public SentForA () {
		super();
	}
	public SentForA (SymbolVariable vari, ExpLog from, Expresion to, Expresion inc) {
		this();
		this.vari=vari;
		this.from=from;
		this.to=to;
		this.inc=inc;
	}
	public SentForA (SymbolVariable vari, ExpLog from, Expresion to, Expresion inc, int offset) {
		this(vari, from, to, inc);
		this.offset=offset;
	}
	
	public SymbolVariable getVariable(){
		return vari;
	}
	public ExpLog getFrom() {
		return from;
	}
	public Expresion getTo() {
		return to;
	}
	public Expresion getInc() {
		return inc;
	}
	public int getOffset() {
		return offset;
	}
}
