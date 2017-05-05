package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;
/**
 * Clase traductora para las operaciones NADA
 * Devuelve una linea vacia, evita NullPointerException
 */
public class TranslatorNADA extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		temporal.append("");
		return  temporal.toString();
	}
}
