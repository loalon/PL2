package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeFunction.
 */

// TODO: Student work
//       Include properties to characterize function declarations

public class TypeFunction  extends TypeProcedure
{   
	private TypeIF returnType;
	//private ScopeIF scope;
    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope.
     */
    public TypeFunction (ScopeIF scope)
    {
        super (scope);
    }
    public TypeFunction (ScopeIF scope, String name)
    {
        super (scope, name);
    }
    /*
    public TypeFunction (ScopeIF scope, String name, ArrayList<TypeIF> parameters, TypeIF returnType)
    {
        super (scope, name, parameters);        
        this.rType = returnType;
    }
    */
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        return 1;
    }
	public TypeIF getReturnType() 
	{
		return returnType;
	}
	public void setReturnType(TypeIF returnType) 
	{
		this.returnType=returnType;
	}
	public TypeIF addParameterType() 
	{
		return returnType;
	}
	
}
