package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;

/**
 * Clase que mantiene el tipo Void
 */
public class TypeSimpleVoid extends TypeSimple 
{
		public TypeSimpleVoid(ScopeIF scope) 
		{
			super(scope, "VOID");		
		}

}
