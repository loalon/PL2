package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones HALT
 * Finaliza el programa
 */

public class TranslatorHALT extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		return ("HALT"+"\n");
	}
}
