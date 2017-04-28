package compiler.code;

import java.util.List;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;
import compiler.semantic.type.TypeString;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class TranslatorCALL extends Translator{
	
	//StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		//scope get level??
		//numero de parametros??
//Registro de activacion		
		Variable result = (Variable)quadruple.getResult();
		int parameters = (int) ((Value) quadruple.getFirstOperand()).getValue();
		//int varSize = (int) ((Value) quadruple.getSecondOperand()).getValue();
		//ScopeIF scope = scopeManager.getCurrentScope();
		
		String name = result.getName();

		ScopeIF scope = result.getScope();
		int level=scope.getLevel();
		
		int varSize=0; 
		//if (!(name.equals("main"))) { 
			List<SymbolIF> symbols = scope.getSymbolTable ().getSymbols(); 
			for (SymbolIF simbolo: symbols) {
				if (simbolo instanceof SymbolVariable) {
					SymbolVariable s = (SymbolVariable) simbolo;
					if (s.getType() instanceof TypeString)
						continue; //ignora los string al asignar direcciones
	
					varSize += s.getType().getSize();
				}
			} 
			
		int tempSize=0; 
		List<TemporalIF> temporales = scope.getTemporalTable ().getTemporals(); 
		for (TemporalIF temp: temporales) { //los temporales son respecto puntero del monton 
			Temporal t = (Temporal) temp;
			tempSize+=t.getSize();
		}
		//}
		
		//PARAMETROS METIDOS
		temporal.append("SUB .SP, #"+(parameters)+"\n"); // almaceno el valor de puntero pila.SP de antes(quito los parametros)
		//System.out.println("numero parametros: "+(parameters+1));
		temporal.append("MOVE .A, .R4\n"); // puntero de pila antes de la llamada, aqui volvera al cerrar RA
		temporal.append("MOVE .IX, .R5\n"); // almacena el valor de .IX en .R5 //guarda el enlace de control
		//añmacena la direccion del RA anterior, del llamador
		temporal.append("MOVE .IY, .R6\n"); // almacena el valor de .SP en .R6 //puntero de heap antes de llamada (se debe volver a el)
		//donde estaba el puntero del heap antes
		//temporal.append("MOVE .PC, .R7\n"); // almacena el valor de .PC en .R7 //puntero de heap antes de llamada (se debe volver a el)
		//temporal.append("ADD .SP, #1\n"); // almaceno el valor de .SP en .IX, esta es la referencia del RA
		temporal.append("MOVE .SP, .IX\n"); // almaceno el valor de .SP en .IX, esta es la referencia del RA
		temporal.append("ADD #"+(varSize+SIZE_RA)+", .IX\n"); //iX+7+tamaño variables dan la posicion de IY
		
		temporal.append("MOVE .A, .IY\n"); //establezco desde donde se almacenan los temporales
		temporal.append("ADD #"+(tempSize+1)+", .IY\n"); //porque quiero apuntar al siguiente hueco libre 
		temporal.append("MOVE .A, .R8\n"); //puntero de pila al final de los temporales, siguiente hueco libre
		//temporal.append("MOVE .IX, .IX\n"); 
		temporal.append("PUSH .IX\n"); // POS ix PUSH #-2[.IX] inserta en la cima de la pila, dir maestra del RA +0
		temporal.append("PUSH #0\n"); //valor del retorno +1
		//temporal.append("PUSH .R7\n"); // POS IX+1dir de retorno IX+1
		temporal.append("PUSH .R4\n"); // valor de puntero antes IX+2
		temporal.append("PUSH .R5\n"); // valor de IX antes IX+3 enlace control
		temporal.append("PUSH .R6\n"); // valor de IY puntero antes I4+4
		temporal.append("PUSH #77\n"); //enlace de acceso +5
		temporal.append("PUSH #888\n"); //valor de prueba +6
		temporal.append("PUSH #888\n"); //valor de prueba +7
		
		temporal.append("MOVE .R8, .SP\n"); //situa el puntero alfinal de los temporales para que empiece el nuevo procedimiento (siguiente hueco libre)
		//hasta aqui el registro de activacion
		
		if (name.equals("main")) 
			return  temporal.toString();
		
		temporal.append("CALL /L_"+name+"\n"); //almacena el PC
		//COMO HAY UN RETURN VOLVEMOS A LO ORIGINAL //devuelve el PC+1
		temporal.append("ADD #"+(SIZE_RA+1)+", .IX\n");
		temporal.append("MOVE .A, .SP\n"); //vuelve al final del RA
		//ahora a desapilar
		
		
		temporal.append("POP .R3\n"); //valor de prueba +7 a la basura
		temporal.append("POP .R3\n"); //valor de prueba +6 a la basura
		temporal.append("POP .R3\n"); //valor de prueba +5 a la basura
		temporal.append("POP .IY\n"); //valor de prueba +4 a la basura
		temporal.append("POP .IX\n"); //valor de prueba +3 a la basura
		temporal.append("POP .SP\n"); //valor de prueba +2 a la basura
		//temporal.append("PUSH #-"+result.getAddress()+"[.IY]\n"); // PUSH #-2[.IX] inserta en la cima de la pila

		// gestion del resultado
		//temporal.append("MOVE #17, .R9\n"); //es solo una prueba
		//temporal.append("ADD #1, .IX\n"); // en A la direccion del valor de retorno (IX+1)
		
		//OJO!!! lo siguiente almacena en el .IX del llamante!!!
		temporal.append("MOVE .R9, #1[.IX]\n"); // inserta el resultado en la direccion referenciada por el A (IX+1)
		//temporal.append("MOVE #"+result.getAddress()+"[.IY], .R9\n"); //almacena valor en R9
		return  temporal.toString();
		//return  ("BR /L_"+ quadruple.getResult().toString());
	}
}
