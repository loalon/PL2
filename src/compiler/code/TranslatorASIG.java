package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorASIG extends Translator {
	

	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		//System.out.println("SOS");
		
		OperandIF result = quadruple.getResult();
		Variable var = (Variable) result;
		
		if(var.getScope().getLevel()==0){ //scope global
			temporal.append("MOVE #1[.IX], /"+var.getAddress()+"\n"); //se mueve a la direccion global reservada
		System.out.println("la var asignada global "+var.getName()+" tiene scope "+ var.getScope().getLevel()+"\n");
		}else {
			//if(var.isParameter()) {
				System.out.println("la var asignada "+var.getName()+" tiene scope "+ var.getScope().getLevel()+"\n");
				temporal.append("MOVE #1[.IX], #"+(var.getAddress()+SIZE_RA+1)+"[.IX] \n"); //OK, lo mueve a la variable que corresponde
			//} else {
			//	temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+(to.getAddress()+1)+"[.IX] \n");
				//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
				//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
				//temporal.append("ADD .R3, #"+to.getAddress()+"\n"); //a R3 le sumo el offset de la variable
				//temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A]\n"); //el temporal se mueve del heap a la direccion referenciada por A
	//		}
		}
	
		return temporal.toString();
		//return("NOP");
	}
}
