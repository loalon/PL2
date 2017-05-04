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

public class TranslatorCALLC extends Translator{
	

	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		Variable result = (Variable)quadruple.getResult();

		ScopeIF scope = result.getScope();
		int level=scope.getLevel();

		temporal.append("ADD #"+(SIZE_RA)+", .IX\n");
		temporal.append("MOVE .A, .SP\n"); //vuelve al final del RA
		//ahora a desapilar

		temporal.append("POP /" + (DISPLAY0-level) + "\n"); //restauro el enlace de acceso previo
		temporal.append("POP .IY\n"); //valor de prueba +4 a la basura
		temporal.append("POP .IX\n"); //valor de prueba +3 a la basura
		temporal.append("POP .SP\n"); //valor de prueba +2 a la basura
		temporal.append("MOVE #"+(level-1)+", /"+(DISPLAY0+1)+"\n"); //resto un nivel de ejecucion

		return  temporal.toString();
		
	
	}
}
