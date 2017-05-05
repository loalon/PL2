package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase traductora para las operaciones START
 * Gestiona el comienzo del programa ensamblador
 */

public class TranslatorSTART extends Translator{
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		//temporal.append("MOVE #65000, .IY\n"); //relativo a monton
		//temporal.append("MOVE .IY, .R8\n"); //relativo a monton
		temporal.append("ADD .PC, #7\n"); //relativo a pila y dos mas
		temporal.append("MOVE .A, .SP\n"); //relativo a pila y dos mas
		temporal.append("MOVE #60000, .IY\n"); //situa el primer puntero de temporales en la direccion 60000		
		
		//temporal.append("BR /L_MAIN");
		
		return  temporal.toString();
	}
}
