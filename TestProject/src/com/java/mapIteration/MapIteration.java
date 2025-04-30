package com.java.mapIteration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class MapIteration {
	
	public static void main(String[] args) {
		
		
	// Different ways to Iterate a Map Object	
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1101, "Kumar");
		map.put(1104, "Bhushan");
		map.put(1102, "Param");
		map.put(1107, "Vinay");
		map.put(1108, "Lakhan");
		
		
	// Approach - 1 = For Each Loop
		
		for(Entry<Integer, String> entry : map.entrySet())
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		System.out.println("********************************************");
		
	// Approach 2 = Iterator
		
		Set<Integer> keys = map.keySet();
		
		Iterator<Integer> itr = keys.iterator();
		
		while(itr.hasNext())
		{
			Integer key = itr.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}

		System.out.println("********************************************");
		
	// Approach 3 = Lambda expression
		
		map.forEach((k,v) -> {
			System.out.println(k+" : "+v);
		});
		
		
		System.out.println("********************************************");
		
	// Approach 4 = entry set
		
		map.entrySet().forEach(System.out::println);
		
		map.entrySet().forEach(k -> System.out.println(k.getKey()+" : "+k.getValue()));
		
		System.out.println("********************************************");
		
	// 	Approach 5
		
		Stream.of(map).forEach(System.out::println);
		
		System.out.println("********************************************");
		
		Stream.of(map).forEach(m -> System.out.println(m));
		
		
		
	}
	

}
