package com.java.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InternetQuestions {
	
	public static void main(String[] args) {
		
		
		String s = "Hi I am a good java developer and I dont quit";
		
		// find the first non-repeating character in the string using stream api
		
		// approach 1
		String first = Stream.of(s.split("")).collect(Collectors.toList()).stream().filter(e -> Collections.frequency(Stream.of(s.split("")).
				collect(Collectors.toList()), e) == 1).collect(Collectors.toList()).stream().findFirst().get();

		System.out.println(first);
		
		// approach 2
		LinkedHashMap<String,Long> map = Stream.of(s.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		Entry<String,Long> findfirst = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get();
		
		System.out.println(findfirst.getKey());
		
		
		//Write Java8 code to print duplicate elements and its count
		 String[] input = {"abc", "abc", "ltim" ,"xyz"};
		 
		 Map<String, Long> stringMap = Stream.of(input).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
		 List<Entry<String, Long>> stringEntryset = stringMap.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toList());
		 
		 stringEntryset.forEach(System.out::println);
		 
		 // storing the stringMap result into MAP approach
		 
		 Map<String, Long> stringMap2 = stringMap.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		 stringMap2.entrySet().forEach(System.out::println);
		 
		// storing the stringMap result into LinkedHashMap approach
		 
		 LinkedHashMap<String, Long> linkedHashMap = stringMap.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
		
		 linkedHashMap.entrySet().forEach(System.out::println);
		 
		 System.out.println(remove("kunal", Arrays.asList("kunal","jick","shri")));
		 
		 // remove the duplicate strings from the list, keeping only the first occurrance while maintaining list order
		 
		 List<String> slist = Arrays.asList("kunal","vibha","mukta","vibha", "kunal","satish","vibha");
		 
		 LinkedHashSet<String> ls = slist.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		 
		 List<String> uniqueList = slist.stream().distinct().collect(Collectors.toList());
		 
		 System.out.println(uniqueList);
		 System.out.println(ls);
		 
		
		
	}
	
	
	
	
	public static List<String> remove(String str, List<String> strList)
	{
		
		List<String> removed = strList.stream().filter(e -> !e.equals(str)).collect(Collectors.toList());		
		return removed;
	}
	
	

}
