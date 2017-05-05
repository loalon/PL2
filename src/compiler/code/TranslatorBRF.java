package compiler.code;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones BRF
 * Salta si falso
 */

public class TranslatorBRF extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Temporal result = (Temporal)quadruple.getResult(); //temporal para guardar si es falso
		Label op1 = (Label)quadruple.getFirstOperand(); // etiqueta de salto si es falso
		temporal.append("CMP #"+result.getAddress()+"[.IY], #0\n"); // CMP #-2[.IX], 0 . compara con 0
		temporal.append("BZ /"+op1+"\n"); //solo si z=1, significa que CMP son iguales
		return  temporal.toString();
	}
}
