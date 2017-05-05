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

public class TranslatorB_START extends Translator{
	
	//StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
	
		Variable result = (Variable)quadruple.getResult();
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

		//temporal.append("MOVE #"+level+", /"+(DISPLAY0+1)+"\n"); //muevo el nivel actual
		temporal.append("INC /"+(DISPLAY0+1)+"\n"); //test
		System.out.println("nivel: "+level);

		temporal.append("MOVE .SP, .R4\n"); // puntero de pila antes de la llamada, aqui volvera al cerrar RA
		temporal.append("MOVE .IX, .R5\n"); // almacena el valor de .IX en .R5 //guarda el enlace de control
		//añmacena la direccion del RA anterior, del llamador
		temporal.append("MOVE .IY, .R6\n"); // almacena el valor de .SP en .R6. puntero de temporales
		temporal.append("MOVE /"+(DISPLAY0-level)+", .R7\n"); // almacena el valor de display anterior
		temporal.append("MOVE .SP, .IX\n"); // almaceno el valor de .SP en .IX, esta es la referencia del RA
		temporal.append("ADD #"+(varSize+SIZE_RA)+", .IX\n"); //iX+7+tamaño variables dan la posicion de IY
		
		temporal.append("MOVE .A, .IY\n"); //establezco desde donde se almacenan los temporales
		temporal.append("ADD #"+(tempSize+1)+", .IY\n"); //porque quiero apuntar al siguiente hueco libre 
		temporal.append("MOVE .A, .R8\n"); //puntero de pila al final de los temporales, siguiente hueco libre
		temporal.append("MOVE .IX, /"+(DISPLAY0-level)+"\n"); //muevo .Ix anterior a su posicion en el display, guarda al anidante
		//temporal.append("MOVE .R5, /"+(DISPLAY0-level)+"\n"); //muevo .Ix anterior a su posicion en el display, guarda al anidante
		temporal.append("PUSH .IX\n"); // POS ix PUSH #-2[.IX] inserta en la cima de la pila, dir maestra del RA +0
		temporal.append("PUSH #0\n"); //valor del retorno +1

		temporal.append("PUSH .R4\n"); // valor de puntero antes IX+2
		temporal.append("PUSH .R5\n"); // valor de IX antes IX+3 enlace control
		temporal.append("PUSH .R6\n"); // valor de IY puntero antes I4+4
		temporal.append("PUSH .R7\n"); //enlace de acceso +5

		
		temporal.append("MOVE .R8, .SP\n"); //situa el puntero alfinal de los temporales para que empiece el nuevo procedimiento (siguiente hueco libre)

		return  temporal.toString();
	}
}
