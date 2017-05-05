package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones INL
 * Crea una etiqueta
 */

public class TranslatorINL extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		return  (""+quadruple.getResult()+":"+"\n");
	}
}
