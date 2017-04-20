package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;

public class TypeSimpleInteger extends TypeSimple 
{
    private boolean esBool=false;
    
	public TypeSimpleInteger(ScopeIF scope) 
	{
		super(scope, "INTEGER");		
	}
	public TypeSimpleInteger(ScopeIF scope, boolean esBool) 
	{
		this(scope);
		this.esBool=esBool;
	}
	
    public boolean esBool() {
    	return esBool;
    }
    public void setBool(boolean esBool) {
    	this.esBool=esBool;
    }
}
