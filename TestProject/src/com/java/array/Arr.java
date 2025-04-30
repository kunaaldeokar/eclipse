package com.java.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class Arr {
	
	public static void main(String[] args) {
		

// 1. find smallest and largest element in the array		
		
		int arr[] = {22, 14, 8, 17, 35, 3};
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		
		
		System.out.println("min = "+min+", max = "+max);
	
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$ 1 $$$$$$$$$$$$$$$$$$$$$$");
		
		
// 2. Reverse the array
		
		//		int arr[] = {22, 14, 8, 17, 35, 3};
		
		int a = 0;
		int b = arr.length-1;
		
		for(int i = 0 ; i < arr.length/2 ; i++)
		{
			
			a = arr[i];
			arr[i] = arr[b];
			arr[b] = a;
			b--;
		}
		

		
		System.out.println(Arrays.toString(arr));
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$ 2 $$$$$$$$$$$$$$$$$$$$$$");
		
		
// 3. sort the numeric array in ascending order
		
		// 		int arr[] = {22, 14, 8, 17, 35, 3};

		
		int temp = 0;
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i+1; j < arr.length ; j++) {
				
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				
			}
			
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$ 3 $$$$$$$$$$$$$$$$$$$$$$");
		
		
// sort the String array in ascending order
		
		String[] sArr = {"Syndra","Bindra", "Lindra", "Zindra","Undra"};
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
