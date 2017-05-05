package compiler.code;

import java.util.Arrays;
import java.util.List;

import compiler.semantic.type.TypeSimple;

import es.uned.lsi.compiler.code.ExecutionEnvironmentIF;
import es.uned.lsi.compiler.code.MemoryDescriptorIF;
import es.uned.lsi.compiler.code.RegisterDescriptorIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;

/**
 * Class for the ENS2001 Execution environment.
 */

public class ExecutionEnvironmentEns2001 
    implements ExecutionEnvironmentIF
{    
    private final static int      MAX_ADDRESS = 65535; 
    private final static String[] REGISTERS   = {
       ".PC", ".SP", ".SR", ".IX", ".IY", ".A", 
       ".R0", ".R1", ".R2", ".R3", ".R4", 
       ".R5", ".R6", ".R7", ".R8", ".R9"
    };
    
    private RegisterDescriptorIF registerDescriptor;
    private MemoryDescriptorIF   memoryDescriptor;
    
    /**
     * Constructor for ENS2001Environment.
     */
    public ExecutionEnvironmentEns2001 ()
    {       
        super ();
    }
    
    /**
     * Returns the size of the type within the architecture.
     * @return the size of the type within the architecture.
     */
    @Override
    public final int getTypeSize (TypeSimple type)
    {      
        return 1;  
    }
    
    /**
     * Returns the registers.
     * @return the registers.
     */
    @Override
    public final List<String> getRegisters ()
    {
        return Arrays.asList (REGISTERS);
    }
    
    /**
     * Returns the memory size.
     * @return the memory size.
     */
    @Override
    public final int getMemorySize ()
    {
        return MAX_ADDRESS;
    }
           
    /**
     * Returns the registerDescriptor.
     * @return Returns the registerDescriptor.
     */
    @Override
    public final RegisterDescriptorIF getRegisterDescriptor ()
    {
        return registerDescriptor;
    }

    /**
     * Returns the memoryDescriptor.
     * @return Returns the memoryDescriptor.
     */
    @Override
    public final MemoryDescriptorIF getMemoryDescriptor ()
    {
        return memoryDescriptor;
    }

    /**
     * Translate a quadruple into a set of final code instructions. 
     * @param cuadruple The quadruple to be translated.
     * @return a quadruple into a set of final code instructions. 
     */
    @Override
    public final String translate (QuadrupleIF quadruple)
    {      
    	Translator translator=null;
    	
    	switch(quadruple.getOperation()) {
			case "ASIG": 
				translator=new TranslatorASIG(); break;
			case "BR": 
				translator=new TranslatorBR(); break;
			case "BRF":
				translator=new TranslatorBRF(); break;
			case "BRT":
				translator = new TranslatorBRT(); break;
			case "CALL":
				translator = new TranslatorCALL(); break;
			case "B_START":
				translator = new TranslatorB_START(); break;
			case "B_END":
				translator = new TranslatorB_END(); break;
			case "HALT":
				translator = new TranslatorHALT(); break;
			case "EQ":
				translator = new TranslatorEQ(); break;
			case "GR":
				translator = new TranslatorGR(); break;				
    		case "INL":
    			translator = new TranslatorINL(); break;			
			case "MV":
				translator = new TranslatorMV(); break;				
			case "NADA":
				translator = new TranslatorNADA(); break;
			case "OR":
    			translator = new TranslatorOR(); break;
			case "ORG":
    			translator = new TranslatorORG(); break;
			case "PARAM":
				translator = new TranslatorPARAM(); break;    			
			case "PRINT":
				translator = new TranslatorPRINT(); break;
			case "RET":
    			translator = new TranslatorRET(); break;
			case "START":
				translator = new TranslatorSTART(); break;
    		case "SUB": 
    			translator = new TranslatorSUB(); break;
    		case "TEXT":
    			translator = new TranslatorTEXT(); break;
    		default:
    			break;
		}
    	translator.setMaxAddress(MAX_ADDRESS); //para saber donde empieza el display array
    	return translator.translate(quadruple); //ejecuta la traduccion
    }
}
