package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import compiler.semantic.type.TypeSimpleInteger;
import compiler.semantic.type.TypeString;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorPRINT extends Translator{
	
	StringBuilder temporal=new StringBuilder();
	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		OperandIF result = quadruple.getResult();
		 
		//3 casos, todos generan un salto de linea y no se admiten caracteres especiales
		
		//que el operando tenga 0 parametros
		if (result.equals(null)) {
			temporal.append("WRCHAR #10"); 		// WRCHAR un char de nueva fila
		}
		
		//un value
		if (result instanceof Value) {
			Value val = (Value) result;
			if (val.getValue() instanceof Integer) { 
				temporal.append("WRINT #"+val.getValue()+"\n");
				temporal.append("WRCHAR #10"); 
			} 
		}
		
		//si es un variable
		if (result instanceof Variable) {
			Variable var = (Variable) result;
			//varaible string
			if (var.getType() instanceof TypeString) {
				temporal.append("WRSTR /"+var.getName()+"\n"); //hago referencia a la etiqueta
				temporal.append("WRCHAR #10"); 
			} else if (var.getType() instanceof TypeSimpleInteger) {
				temporal.append("WRINT /"+var.getAddress()+"\n");
				temporal.append("WRCHAR #10"); 
			}
		}
		if (result instanceof Temporal) {
			Temporal var = (Temporal) result;
			temporal.append("WRINT /"+var.getAddress()+"\n"); //hago referencia a la etiqueta
			temporal.append("WRCHAR #10"); 
		
		}
		
		//} else if (results i)
		//que el operando sea un int
		
		//que el operando sea un string
		//??añadir retorno de carrio?? eso es el #13
		// no puede imprimir matrices o registros enteros
		
		return temporal.toString();
	}
}
