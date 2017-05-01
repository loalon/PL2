package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolFunction.
 */


public class SymbolFunction  extends SymbolProcedure
{
	//private ScopeIF scope;
	//private TypeIF type;
	//private String name;
	//private int numeroParametros;
	//private int size;
    /**
     * Constructor for SymbolFunction.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolFunction (ScopeIF scope,  String name, TypeIF type)
    {
        super (scope, name, type);
        //this.numeroParametros=numeroParametros;
    } 	
    public SymbolFunction (ScopeIF scope,  String name, TypeIF type, int numeroParametros)
    {
        super (scope, name, type, numeroParametros);
        //this.numeroParametros=numeroParametros;
    } 

	//public int getNumeroParametros(){
		//return numeroParametros;
	//}
}
