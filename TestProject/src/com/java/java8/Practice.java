package com.java.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.java8.employee.Employee;

public class Practice {
	
	public static void main(String[] args) {
		
		
		// Find the duplicate elements and their count of duplication
		
				List<Integer> list = Arrays.asList(3, 7, 9, 3, 0, 1, 4,5,3,5,6,4,1,8,4,6,4,5,2,3,5,6,3,5,4);
				
					Map<Integer,Long> duplicateCount= list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));				
		
					duplicateCount.entrySet().forEach(System.out::println);
					
					
		// Reverse the String by Stream API
					
				String str = "This is a java Programm";			
		
					String reverse = Stream.of(str.split("")).toList().stream().reduce((a,b) -> b+a).get();
		
					System.out.println(reverse);
					
					
		// Group the elements by odd and even.
					
				List<Integer> numList = Arrays.asList(3, 7, 9, 3, 0, 1, 4, 5, 23, 15);
				
				Map<String, List<Integer>> oddEven = numList.stream().collect(Collectors.groupingBy(num -> num %2 == 0 ? "Even" : "Odd"));
		
				oddEven.entrySet().forEach(System.out::println);
				
				
		// Get the largest element from the list
				
				List<Integer> list2 = Arrays.asList(3, 7, 9, 3, 0, 1, 4, 5, 23, 15);				
		
				Integer largeNumber = list2.stream().max(Comparator.comparing(Integer::valueOf)).get();
		
				System.out.println(largeNumber);
				
				
		// Remove the duplicate elements or print unique elements only from the list
				
				List<Integer> list3 = Arrays.asList(3, 7, 9, 3, 0, 1, 4,5,3,5,6,4,1,8,4,6,4,5,2,3,5,6,3,5,4);
				
				List<Integer> uniqueElements = list3.stream().filter(e -> Collections.frequency(list3, e) == 1).collect(Collectors.toList());
				
				System.out.println(uniqueElements);
				
				
		// Find the frequency of each character in a string
				
				String s = "Hello this is a java program";		
				
				Map<Character, Long> charCount = s.chars().mapToObj(e -> (char)e).toList().stream().filter(e -> e != ' ').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				charCount.entrySet().forEach(System.out::println);
				
				
		// find the first repeated appearing character from the string
				
				String ss = "Hello this is a java program";
				
				List<Character> charlist = ss.chars().mapToObj(e -> (char)e).toList();
				
				Character ch = charlist.stream().filter(e -> Collections.frequency(charlist, e) > 1 && e!=' ').findFirst().get();
				
				System.out.println(ch);
				
				// first repeating character along with it's count
				
				Entry<Character, Long> entry = charlist.stream().filter(e -> e!=' ' && Collections.frequency(charlist, e) > 1)
							.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().findFirst().get();
				
				System.out.println(entry);
				
				
				
		// filter the list with specific digit start (e.g. numbers starting with 1)
				
				List<Integer> list4 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
				
				List<Integer> starts = list4.stream().filter(st -> st.toString().startsWith("1")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
		
				System.out.println(starts);
				
				
		// sort the list in descending order by java 8
				
				List<Integer> list5 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
		
				List<Integer> reverseOrder = list5.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				
				System.out.println(reverseOrder);
							
	
		// find the sum of all the elements in the list
						
				List<Integer> list6 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);	
				
				Integer collect = list6.stream().collect(Collectors.summingInt(Integer::valueOf));
				
				Integer sum = list6.stream().reduce((a,b) -> a+b).get();
				
				IntSummaryStatistics stat = list6.stream().collect(Collectors.summarizingInt(Integer::valueOf));
				
				System.out.println(stat.getSum());
						
				
				
				
				
				
		
		
		
	}

}
