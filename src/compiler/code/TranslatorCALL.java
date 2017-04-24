package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorCALL extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
//Registro de activacion		
		Variable result = (Variable)quadruple.getResult();
		
		//temporal.append("SUB .SP, #1\n"); // almaceno el valor de .SP
		temporal.append("MOVE .SP, .R4\n"); // almacena el valor de .SP en .R4 //puntero antes de la llamada
		temporal.append("MOVE .IX, .R5\n"); // almacena el valor de .SP en .R5 //llamador
		temporal.append("MOVE .IY, .R6\n"); // almacena el valor de .SP en .R6 //puntero de heap antes de llamada (se debe volver a el)
		//temporal.append("MOVE .PC, .R7\n"); // almacena el valor de .SP en .R6 //puntero de heap antes de llamada (se debe volver a el)
		//temporal.append("MOVE .SP, .IX\n"); // almaceno el valor de .SP en .IX, esta es la referencia del RA
		temporal.append("MOVE .SP, .IX\n"); // almaceno el valor de .SP en .IX, esta es la referencia del RA
		temporal.append("PUSH .IX\n"); // PUSH #-2[.IX] inserta en la cima de la pila
		
		temporal.append("PUSH #77\n"); // valor de retorno IX+1
		
		temporal.append("PUSH .R4\n"); // valor de puntero antes IX+2
		temporal.append("PUSH .R5\n"); // valor de IX antes IX+3
		temporal.append("PUSH .R6\n"); // valor de puntero antes IX+2
		//temporal.append("PUSH #0\n"); //enlace de control
		//temporal.append("PUSH #0\n"); //enlace de acceso
		//temporal.append("PUSH #-"+result.getAddress()+"[.IY]\n"); // PUSH #-2[.IX] inserta en la cima de la pila
		//dir retorno
		//
		
		
		return  temporal.toString();
		//return  ("BR /L_"+ quadruple.getResult().toString());
	}
}
