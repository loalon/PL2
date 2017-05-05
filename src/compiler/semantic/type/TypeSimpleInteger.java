package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;

/**
 * Clase que mantiene el tipo integer
 * 
 */
public class TypeSimpleInteger extends TypeSimple 
{
    //private boolean isBool=false; //por defecto no corresponde a un boolean
    
	public TypeSimpleInteger(ScopeIF scope) 
	{
		super(scope, "INTEGER");		
	}
	/*
	public TypeSimpleInteger(ScopeIF scope, boolean isBool) 
	{
		this(scope);
		this.isBool=isBool;
	}
	
    public boolean esBool() {
    	return isBool;
    }
*/
    
}
