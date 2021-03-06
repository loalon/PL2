package compiler.code;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones ORG
 * Reserva un numero de posiciones en memoria para variables locales
 */

public class TranslatorORG extends Translator{
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		temporal.append("ORG "+ quadruple.getResult().toString()+"\n");
		
		return  temporal.toString();
	}
}
