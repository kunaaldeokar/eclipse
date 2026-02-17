package com.java.java8;

import java.util.Collections;
import java.util.LinkedHashMap;
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
		
		
		
		
	}

}
