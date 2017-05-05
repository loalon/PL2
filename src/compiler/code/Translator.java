package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Clase abstracta que los traductores heredan
 */

public abstract class Translator {

	protected int SIZE_RA=6; //este es el tamaño del RA
	protected int DISPLAY0; // aqui empieza el array del display
	StringBuilder temporal=new StringBuilder(); //aqui se construye el string
	
	public Translator() {	
		
	}
	protected abstract String translate(QuadrupleIF quadruple);

	protected void setMaxAddress(int max){
		DISPLAY0=max-1; //debe reservar la ultima posicion para mantener el scope activo
	}
}
