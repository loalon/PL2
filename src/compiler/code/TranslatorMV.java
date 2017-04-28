package compiler.code;

import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.intermediate.Variable;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

public class TranslatorMV extends Translator {
	

	
	@Override
	protected String translate(QuadrupleIF quadruple) {
		
		LabelFactory lf = new LabelFactory();
		LabelIF labelLocal = lf.create();
		LabelIF labelNoLocal = lf.create();
		
		OperandIF result = quadruple.getResult();
		OperandIF op1 = quadruple.getFirstOperand();
		//OperandIF op2= quadruple.getSecondOperand(); //guarda desplazamiento relativo
		
		//caso 1 mover constante, result sera un temp y op1 un valor
		//MV temporal cnte
		if(result instanceof Temporal && op1 instanceof Value) {
			Value from = (Value) op1;
			Temporal to = (Temporal) result;
			temporal.append("MOVE #"+ from.getValue() +", #"+to.getAddress()+"[.IY]\n");  
			//temporal.append("DEC .R8\n");
			//temporal.append("DEC .R8\n");
		}
	
		//caso 2 mover temporal --> variable
		if(result instanceof Variable && op1 instanceof Temporal) {
			
			Temporal from = (Temporal) op1;
			Variable to = (Variable) result;
			int level = to.getScope().getLevel();
			//es global?
			if(level==0) //scope global
				temporal.append("MOVE #"+ from.getAddress()+"[.IY], /"+to.getAddress()+"\n"); //se mueve a la direccion global reservada
			else {
				if(to.isParameter()) {
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("SUB .IX, #"+to.getAddress()+"\n"); //le quito el offset de la var
					//temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A] \n"); //el temporal se mueve del heap a la direccion referenciada por A
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+to.getAddress()+"[.IX] \n");
				} else {
					//comparar el display0+1 (el sitio donde dice que ambito es el actual)//con el nivel de esta variable
					temporal.append("CMP /"+(DISPLAY0+1)+", #"+level+"\n"); //el resultado al registro temporal R3
					temporal.append("BZ /"+labelLocal+"\n"); //si so iguales es referencia local
					temporal.append("ADD #"+(to.getAddress()+SIZE_RA+1)+", /"+(DISPLAY0-level)+"\n"); 
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A] \n"); 
					temporal.append("BZ /"+labelNoLocal+"\n"); //si so iguales es referencia local
					temporal.append(labelLocal+":"+"\n"); //etiqueta si verdadero
					temporal.append("MOVE #"+ from.getAddress()+"[.IY], #"+(to.getAddress()+SIZE_RA+1)+"[.IX] \n"); //ESTA ES BUENA y ANTES UNICA
					temporal.append(labelNoLocal+":"+"\n"); //etiqueta si verdadero
					//si son distintos es una glocal
					//y entonces tengo que buscar el display[] indicado por el level de esta variable y apuntar a
					//la direccion anotada alli mas el scope
					
					
					//porque mas uno???
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("ADD .R3, #"+to.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE #"+ from.getAddress()+"[.IY], [.A]\n"); //el temporal se mueve del heap a la direccion referenciada por A
				}
			}
			//es local??
			//es glocal?
			
			
		}
		//caso 3 mover variable a un temporal (para imprimir por ejemplo)
		if(result instanceof Temporal && op1 instanceof Variable) {
			Variable from = (Variable) op1;
			Temporal to = (Temporal) result;
			int level = from.getScope().getLevel();
			if(level==0) //scope global
				temporal.append("MOVE /"+ from.getAddress()+", #"+to.getAddress()+"[.IY]");  
			else {
				if(from.isParameter()) {
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("SUB .IX, #"+from.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE  [.A], #"+ to.getAddress()+"[.IY] \n"); //el temporal se mueve del heap a la direccion referenciada por A
					temporal.append("MOVE #"+ from.getAddress()+"[.IX], #"+to.getAddress()+"[.IY] \n");
				} else {
					//temporal.append("MOVE #"+ (from.getAddress()+SIZE_RA+1)+"[.IX], #"+to.getAddress()+"[.IY] \n"); //ANTIGUA BUENA
					
					temporal.append("CMP /"+(DISPLAY0+1)+", #"+level+"\n"); //el resultado al registro temporal R3
					temporal.append("BZ /"+labelLocal+"\n"); //si so iguales es referencia local
					temporal.append("ADD #"+(from.getAddress()+SIZE_RA+1)+", /"+(DISPLAY0-level)+"\n"); 
					temporal.append("MOVE [.A], #"+ from.getAddress()+"[.IY]\n"); 
					
					//temporal.append("MOVE #"+(from.getAddress()+SIZE_RA+1)+"[/"+(DISPLAY0-level)+"] , #"+ to.getAddress()+"[.IY] \n"); 
					temporal.append("BZ /"+labelNoLocal+"\n"); //si so iguales es referencia local
					temporal.append(labelLocal+":"+"\n"); //etiqueta si verdadero
					temporal.append("MOVE #"+ (from.getAddress()+SIZE_RA+1)+"[.IX], #"+to.getAddress()+"[.IY] \n");
					temporal.append(labelNoLocal+":"+"\n"); //etiqueta si verdadero
					
					//temporal.append("ADD #"+SIZE_RA+", .IX\n"); //la septima posicion desde Ix comienza a guardar var locales
					//temporal.append("MOVE .A, .R3\n"); //el resultado al registro temporal R3
					//temporal.append("ADD .R3, #"+from.getAddress()+"\n"); //a R3 le sumo el offset de la variable
					//temporal.append("MOVE [.A], #"+to.getAddress()+"[.IY]\n"); 
					//temporal.append("DEC .R8\n");	
				}
				
			}
			
			// 
		}
		// caso 4 copiar una variable en una nueva variable 

		return temporal.toString();
	}
}
