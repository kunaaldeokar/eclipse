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
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	

	public static void main(String[] args) {
		
// Find the duplicate elements and their count of duplication
		
		List<Integer> list = Arrays.asList(3, 7, 9, 3, 0, 1, 4,5,3,5,6,4,1,8,4,6,4,5,2,3,5,6,3,5,4);

		Map<Integer, Long> duplicate = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Duplicate Elements and count : "+duplicate);
		
		System.out.println();
		
		
// Reverse the String by Stream API
		
		String str = "This is a java Programm";
		
		String reverse = Stream.of(str.split("")).reduce((a,b) -> b+a).get();
		
		System.out.println("Reversed String : "+reverse);
		
		System.out.println();
		
		
// Group the elements by odd and even.
		
		List<Integer> numList = Arrays.asList(3, 7, 9, 3, 0, 1, 4, 5, 23, 15);
		
		// ? = ternary operator
		Map<String, List<Integer>> oddEven = numList.stream().collect(Collectors.groupingBy(e -> e%2 == 0 ? "even" : "odd"));
		
		System.out.println(oddEven);
		
		System.out.println();
		
	
// Get the largest element from the list
		
		List<Integer> list2 = Arrays.asList(3, 7, 9, 3, 0, 1, 4, 5, 23, 15);
		
		Integer largest = list2.stream().max(Integer::compareTo).get();
		
		Integer largestOpt = list2.stream().max(Comparator.comparing(e -> e)).get();
		
		Integer largestOpt2 = list2.stream().max(Comparator.comparing(Integer::valueOf)).get();
		
		System.out.println("Largest Element is : "+largest);
		
		System.out.println();
		
		
// Remove the duplicate elements or print unique elements only from the list
		
		List<Integer> list3 = Arrays.asList(3, 7, 9, 3, 0, 1, 4,5,3,5,6,4,1,8,4,6,4,5,2,3,5,6,3,5,4);

		List<Integer> unique = list3.stream().filter(e -> Collections.frequency(list3, e) == 1).toList();
		
		System.out.println(unique);
		
		System.out.println();

		
// Find the frequency of each character in a string
		
		String s = "Hello this is a java program";
		
		List<Character> charList = s.chars().mapToObj(e -> (char)e).map(Character::toLowerCase).toList();
		
		Map<Character, Long> occ = charList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		/* chars() => it is a method of String class which returns the Intstream for a string
		 represent the stream of unicode of each characters. */
		
		System.out.println(occ);
		
		// first repeating character along with it's count
		
		Entry<Character, Long> entry = charList.stream().filter(e -> e!=' ' && Collections.frequency(charList, e) > 1)
					.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().findFirst().get();
		
		System.out.println(entry);
		
		System.out.println();
		
		
// filter the list with specific digit start (e.g. numbers starting with 1)
		
		List<Integer> list4 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
		
		List<Integer> result4 = list4.stream().map(e -> e.toString())
								.filter(e -> e.startsWith("1"))
								.mapToInt(Integer::valueOf).boxed().toList();
		
		System.out.println("numbers starting with '1' : "+result4);
		
		System.out.println();
		
		/*
		 * How it works for mapToInt.boxed()
		 * 
		 * mapToInt method will convert all the input elements into IntStream (Stream of int-primitive),
		 * means it will convert each element into int-primitive (not Integer) and return IntStream.
		 * 
		 * boxed() method will helps to convert primitive stream into Stream<Integer> 
		 * (into wrapper class stream).
		 * 
		 * */
		
		
// sort the list in descending order by java 8
		
		List<Integer> list5 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
		
		List<Integer> reversed = list5.stream().sorted(Comparator.reverseOrder()).toList();
		
		List<Integer> reversedOpt = list5.stream().sorted((a,b) -> b.compareTo(a)).toList();
		
		System.out.println("Descending order List by java 8 : "+reversed);
		
		System.out.println();
		

// sort the list in descending order by Collections utility
		
		List<Integer> list9 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);		
		
		Collections.sort(list9, Collections.reverseOrder());
		
		System.out.println("Descending order List by simple Collections : "+list9);
		
		System.out.println();
		
		
		
// find the sum of all the elements in the list
		
		List<Integer> list6 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
		
		Integer sum = list6.stream().reduce((a,b) -> a+b).get();
		
		System.out.println("sum of all the elements : "+sum);
		
		System.out.println();
		
		
// reverse the list using java 8 (do not practice)
		
		List<Integer> list7 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);
		
		List<Integer> result7 = IntStream.range(0, list7.size()).mapToObj(e -> list7.get(list7.size() - 1 - e)).toList();
		
		System.out.println("Reversed List by Java 8 : "+result7);
		
		System.out.println();
		
	
// reverse the list using simple Collections utility
		
		List<Integer> list8 = Arrays.asList(11,54,56,3,54,111,12,34,64,13,45);		
		
		Collections.reverse(list8);
		
		System.out.println("Reverse List by Collections : "+list8);
		
		System.out.println();
		
		
// find the common elements from two lists
		
		List<Integer> listOne = Arrays.asList(234,54,34,2,4356,567,453,236);
		
		List<Integer> listTwo = Arrays.asList(1,23,34,2,45,567,453,78);
		
		List<Integer> common = listOne.stream().filter(listTwo::contains).toList();
		
		System.out.println("common elements in two lists : "+common);
		
		System.out.println();
		
		
// find three highest numbers in list
		
		List<Integer> list10 = Arrays.asList(234,54,34,2,4356,567,453,236);
		
		List<Integer> highest3 = list10.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
		
		System.out.println("3 highest elements : "+highest3);
		
		System.out.println();
		
		
// sort the string list according to string length
		
		List<String> list11 = Arrays.asList("Keshav","Madhav","Leena","Durgesh","Mahalaxmi", "Saraswathi","Sam");
		
		List<String> sortedString = list11.stream().sorted((a,b) -> a.length() - b.length()).toList();
		
		List<String> sortedString2 = list11.stream().sorted(Comparator.comparing(String::length)).toList();
		
		System.out.println("Sorted String List by String length : "+sortedString);
		
		System.out.println();
		
		
// sum and average of the ARRAY
		
		int ar1[] = {5,3,5,3,3,5,3,3,8,5,2,673,78};
		
		int arrSum = Arrays.stream(ar1).sum();
		
		double arrAvg = Arrays.stream(ar1).average().getAsDouble();
		
		System.out.println("Array sum : "+arrSum+" Array average : "+arrAvg);
		
		System.out.println();
		
		
// sum of all the digits in a number
		
		Integer num1 = 23434534;
		
		Integer sumOfDigits = Stream.of(String.valueOf(num1).split("")).collect(Collectors.summingInt(Integer::parseInt));
		
		System.out.println("Sum of all the digits : "+sumOfDigits);
		
		// another way
		
		Integer i = Stream.of(num1.toString().split("")).mapToInt(Integer::valueOf).boxed().reduce((a,b) -> a+b).get();
		
		System.out.println("Sum of All digits = "+i);
		System.out.println();
		
	
// merge two list 
		
		List<Integer> listA = Arrays.asList(4,6,4,1,7,4);
		
		List<Integer> listB = Arrays.asList(21,7,4,23,8,76,9);
		
		List<Integer> mergeList = Stream.concat(listA.stream(), listB.stream()).toList();
		
		System.out.println("Merging two lists = "+mergeList);
		
		System.out.println();
		

// merge the two list without duplicate
		
		List<Integer> listC = Arrays.asList(4,6,4,1,7,4);
		
		List<Integer> listD = Arrays.asList(21,7,4,23,8,76,9);
		
		List<Integer> mergeWithoutDuplicate = Stream.concat(listC.stream(), listD.stream()).distinct().toList();
		
		System.out.println("Merge two list without including duplicates : "+mergeWithoutDuplicate);
		
		System.out.println();
		

// how to get sum, average, smallest number, largest number through one line code
		
		List<Integer> list12 = Arrays.asList(11,54,56,3,54,111,12,34,64,2,6,13,45);

		IntSummaryStatistics stat = list12.stream().collect(Collectors.summarizingInt(Integer::valueOf));
		
		System.out.println("Sum of all elements : "+stat.getSum());
		System.out.println("Average of all elements : "+stat.getAverage());
		System.out.println("Largest number among list : "+stat.getMax());
		System.out.println("smallest number among list : "+stat.getMin());
		System.out.println("Number of elements in the list : "+stat.getCount());
		

// check if certain number is available
		
		List<Integer> list13 = Arrays.asList(11,54,56,3,54,111,12,34,64,2,6,13,45);

		System.out.println(isAvailable(list13, 10));
		
		
// concatenate all strings in a list
		
		 List<String> list14 = List.of("Hello", " ", "World", "!");
		
		 String stringConcate = list14.stream().collect(Collectors.joining());
		
		 System.out.println(stringConcate);
		

// Group the cities according to their initials
		 
		String[] strArr = {"Pune", "Patana", "Delhi", "Chennai"};
		
		// convert string array into list
		
		Map<Character, List<String>> result15 = Stream.of(strArr).toList().stream().collect(Collectors.groupingBy(e -> e.charAt(0), Collectors.toList()));

		result15.entrySet().forEach(System.out::println);
		
		
// find the average length of the strings in the list
		
        List<String> list16 = List.of("apple", "banana", "orange", "grape", "kiwi");

        Double result16 = list16.stream().collect(Collectors.averagingInt(String::length));
        
        System.out.println(result16);
        
        
// find the length of each String in list of string
        
        List<String> list17 = List.of("apple", "banana", "orange", "grape", "kiwi");

        Map<String, Integer> result17 = list17.stream().collect(Collectors.toMap(Function.identity(), e -> e.length()));
        
        result17.entrySet().forEach(System.out::println);
        
 
// find the frequency of the given character in the list of String
        
        List<String> list18 = List.of("apple", "banana", "orange", "grape", "kiwi");
        
        Long result18 = list18.stream().flatMapToInt(CharSequence::chars).filter(ch -> ch=='e').count();
        
        System.out.println(result18);
        
        
// check if all the numbers are above 25 or not
        
        List<Integer> list19 = List.of(10, 20, 30, 40, 50);
        
        Boolean result19 = list19.stream().allMatch(n -> n>25);
        
        System.out.println(result19);
        
 
// this is a test comment to test if git is working or not on this platform        
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Boolean isAvailable(List<Integer> list, Integer targetNum)
	{
		return list.stream().anyMatch(e -> e == targetNum);
	}

}
