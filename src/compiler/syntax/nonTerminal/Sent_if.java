package compiler.syntax.nonTerminal;

public class Sent_if extends NonTerminal {

	private Expresion expresion;
	private Sentencia sentenciaThen;
	private Sentencia sentenciaElse;
	
	public Sent_if ( ) {
		super();
	}	
	public Sent_if (Expresion exp) {
		this();
		this.expresion=exp;
	}
	public Sent_if (Expresion exp, Sentencia sentenciaThen) {
		this(exp);
		this.sentenciaThen=sentenciaThen;
	}
	public Sent_if (Expresion exp, Sentencia sentenciaThen, Sentencia sentenciaElse) {
		this(exp, sentenciaThen);
		this.sentenciaElse=sentenciaElse;
	}	
	
	public Expresion getExpresion()	{
		return expresion;
	}
	public Sentencia getSentenciaThen()	{
		return sentenciaThen;
	}	
	public Sentencia getSentenciaElse()	{
		return sentenciaElse;
	}	
}
