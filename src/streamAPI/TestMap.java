package streamAPI;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		
		Map<Integer,String> map=new TreeMap();
		map.put(10, "A");
		map.put(2, "B");
		map.put(1, "C");
		
		//Set<Entry>   entrySet();
		//Set<key>    keySet();
		// Collection  Values();
		
Set<Entry<Integer, String>> entryObj = map.entrySet();

for(Entry<Integer,String> e: entryObj)
{
	int roll = e.getKey();
	String name = e.getValue();
	System.out.println(roll+" "+name);
}
	
	}

}
