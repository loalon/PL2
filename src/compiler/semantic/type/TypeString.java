package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;

/**
 * Clase que mantiene el tipo String
 */
public class TypeString extends TypeBase
{
	public TypeString(ScopeIF scope) 
	{
		super(scope, "STRING");		
	}
}
