package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorRET extends Translator {

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		
		/*
		 * 
		 * 		Temporal op1 = (Temporal)quadruple.getResult();
		
		if(op1 != null)
		{
			// Retorno de una función.
			
			// [CI] RET temporal --> [CF] ??
			
			// Sentencia RET de una llamada a función. Hay que escribir el valor
			// contenido en el temporal en el valor de retorno del RA del llamador.
			setInstruction("MOVE [.IX], .R0");
			setInstruction("INC .R0");
			setInstruction(String.format("%s #-%s[.IX], [.R0]", "MOVE", op1.getAddress()));	
		}
		
		// Esta instrucción es equivalente a:
		// - POP PC
		// - BR [.PC]
		setInstruction("RET");
		 */
		return  ("RET");
	}

}
