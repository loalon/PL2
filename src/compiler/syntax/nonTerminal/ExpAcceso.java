package compiler.syntax.nonTerminal;

import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpAcceso extends NonTerminal {

	private TypeIF tipo=null;
	private String s1;
	private String s2;
	private String s3;
	private SymbolVariable var=null;
	private int offset;
	
	public ExpAcceso () {
		super();
	}
	public ExpAcceso (TypeIF tipo) {
		this();
		this.tipo=tipo;
	}
	public ExpAcceso (String s1, String s2, TypeIF tipo, SymbolVariable var) {
		this();
		this.s1=s1;
		this.s2=s2;
		this.tipo=tipo;
		this.var=var;
	}
	public ExpAcceso (String s1, String s2, TypeIF tipo, SymbolVariable var, int offset) {
		this(s1,s2,tipo,var);
		this.offset=offset;
	}
	
	public ExpAcceso (String s1, String s2, String s3, TypeIF tipo, SymbolVariable var) {
		this(s1,s2,tipo,var);
		this.s3=s3;
	}
	public ExpAcceso (String s1, String s2, String s3, TypeIF tipo, SymbolVariable var, int offset) {
		this(s1,s2,s3,tipo,var);
		this.offset=offset;
	}
	public TypeIF getType () {
		return tipo;
	}
	//WIP eliminaremos esto
	public SymbolVariable getVariable() {
		return var;
	}
	
	public int getOffset() {
		return offset;
	}
	public String getName() {
		return s1;
	}
	//public set ()
	
	//long hascode()
	//boolean equals (Object o)
	// public String toString()
}
