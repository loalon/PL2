package compiler.syntax.nonTerminal;

import java.util.HashMap;
import java.util.Map;

public class Camporeg extends NonTerminal {

	private int size = 0;
	private Map<String, Integer> offset= new HashMap<String, Integer>();
	
	public Camporeg () {
		super();
	}
	
	public void add(String name, int size) {
		offset.put(name, this.size);
		this.size=this.size+size;
	}

	public int getSize () {
		return size;
	}
	public Map<String,Integer> getOffsetMap () {
		return offset;
	}

}
