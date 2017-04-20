package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public abstract class Translator {

	public Translator() {	

	}
	protected abstract String translate(QuadrupleIF quadruple);

}
