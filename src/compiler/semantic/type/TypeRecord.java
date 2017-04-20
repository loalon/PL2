package compiler.semantic.type;

import java.util.HashMap;
import java.util.Map;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeRecord.
 */

// TODO: Student work
//       Include properties to characterize records

public class TypeRecord extends TypeBase
{   
	//private String name;
	//private Map<String, TypeIF> fields = new HashMap<String, TypeIF>();
	private Map<String, Integer> offset= new HashMap<String, Integer>();
	private int size=0;
	//private ScopeIF scope;
	
       
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     */
    public TypeRecord (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeRecord (ScopeIF scope, String name)
    {   
        super (scope, name);
    }
   
    /**
     * Constructor for TypeRecord.
     * @param record The record to copy.
     */
    public TypeRecord (TypeRecord record)
    {
        super (record.getScope (), record.getName ());
    } 
    
    public TypeRecord (ScopeIF scope, String name, int size, Map<String, Integer> map)
    {   
        super (scope, name);
        this.size=size;
        this.offset=map;
    }
    /*
    public void addField(String name, TypeIF type){
    	//añade campo y calcula su tamaño
    	
    	fields.put(name, type);
    	if (type instanceof TypeRecord){
    		int size= type.getSize();
    		offset.put(name, size);
    	}
    	
    }
    */
    public void addOffsetMap(Map<String, Integer> map){
    	this.offset=map;
    }
    public void setSize(int size){
    	this.size=size;
    }
    public int getOffset(String name){ //para una variable, devuelve su desplazamiento
    	return offset.get(name);
    }
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return size;
    }
    

}
