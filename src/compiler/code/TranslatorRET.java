package compiler.code;

import compiler.intermediate.Temporal;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorRET extends Translator {
	
	//StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Temporal result = (Temporal)quadruple.getResult();
		if (!(result==null)) {
			
			//el valor de R9 tiene que pasar al temporal
			temporal.append("MOVE #"+result.getAddress()+"[.IY], .R9\n"); //almacena valor en R9
			//setInstruction("INC .R0");
			//setInstruction(String.format("%s #-%s[.IX], [.R0]", "MOVE", op1.getAddress()));	
		} else {
			temporal.append("MOVE #0, .R9\n"); //si no tiene que retornar nada, R9 a cero, por si acaso
		}
		temporal.append("RET\n"); // recupera PC y continua
		
		//si temporal nulo
		//mete un 0 en la casilla 9
		//siempre acaba con RET
		//temporal.append("MOVE #-"+result.getAddress()+".SP\n"); // PUSH #-2[.IX] inserta en la cima de la pila
		//temporal.append("PUSH #-"+result.getAddress()+".SP\n"); // PUSH #-2[.IX] inserta en la cima de la pila

		
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
		return  temporal.toString();
	}

}
