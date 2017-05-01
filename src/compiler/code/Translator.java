package compiler.code;

import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public abstract class Translator {

	protected int SIZE_RA=5;//7 para las pruebas
	protected int DISPLAY0;
	StringBuilder temporal=new StringBuilder();
	
	public Translator() {	
		
	}
	protected abstract String translate(QuadrupleIF quadruple);

	protected void setMaxAddress(int max){
		DISPLAY0=max-1; //debe reservar la ultima posicion para mantener el scope activo
	}
}
