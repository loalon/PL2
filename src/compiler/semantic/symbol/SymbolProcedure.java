package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure calls

public class SymbolProcedure extends SymbolBase
{
	private int numeroParametros=0;
    /**
     * Constructor for SymbolProcedure.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolProcedure (ScopeIF scope, String name, TypeIF type)
    {
        super (scope, name, type);

    } 	
    public SymbolProcedure (ScopeIF scope, String name, TypeIF type, int numeroParametros)
    {
        this (scope, name, type);
        this.numeroParametros=numeroParametros;
    } 
	public int getNumeroParametros(){
		return numeroParametros;
	}
	public void setNumeroParametros(int numeroParametros){
		this.numeroParametros = numeroParametros;
	}
}
