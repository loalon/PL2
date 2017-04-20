package compiler.syntax.nonTerminal;

public class Operador extends NonTerminal {

	private String tipoOperador;
	
	public Operador (String tipoOperador) {
		super();
		this.tipoOperador=tipoOperador;
	}
	
	public String getTipoOperador(){
		return tipoOperador;
	}

}
