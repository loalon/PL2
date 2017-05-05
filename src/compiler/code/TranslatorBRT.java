package compiler.code;

import compiler.intermediate.Label;
import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones BRT
 * Salta si verdadero
 */

public class TranslatorBRT extends Translator{
		//StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Temporal result = (Temporal)quadruple.getResult(); //temporal para guardar si es verdad
		Label op1 = (Label)quadruple.getFirstOperand(); // etiqueta de salto si verdadero
		
		temporal.append("CMP #"+result.getAddress()+"[.IY], #1\n"); // CMP #-2[.IX], 1 . compara con 1
		temporal.append("BZ /"+op1+"\n"); //solo si z=1, comparacion verdadera. si z=1 significa que CMP son iguales
		return  temporal.toString();
	}
}

