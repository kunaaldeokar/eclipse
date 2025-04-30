package com.java.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1 {
	
	public static void main(String[] args) {
		
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		 
		 List<String> words = Arrays.asList("Java", "Python", "JavaScript");
		 
		 List<Integer> result = words.stream().map(e -> e.length()).toList();
		 
		 System.out.println(result);
		 
		 
		 
		 
	}

}
