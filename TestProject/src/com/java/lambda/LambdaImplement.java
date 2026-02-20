package com.java.lambda;

public class LambdaImplement {
	
	public static void main(String[] args) {
		
		
	// no return no parameters	
		
		Action a = () -> System.out.println("no return, no params");
		
		a.run();
		
		Action a1 = () -> {
			System.out.println("multiline lambda");
			System.out.println("no return, no params");
		};
		
		a1.run();
		
		
// -------------------------------------------------------------------------------------	
		
	// return, no parameters
		
		Procedure p = () -> "return, no params";
		
		System.out.println(p.get());
		
		Procedure p1 = () -> {
		
		int z = 10;
		int b = 20;
		
		int c = z+b;
		
		return "the sum is "+c;
		
		};
		
		System.out.println(p1.get());
	
		
// -------------------------------------------------------------------------------------
		
	// no return, one parameter
		
		Budget budget = amt -> System.out.println("amount spent is "+amt);
		
		budget.spend("Twelve thousand rupees");
		
		
// -------------------------------------------------------------------------------------
		
	// return, one parameter
		
		Character character = age -> {
			
			return "He is a good person of age : "+age;
			
		};
		
		System.out.println(character.personAge(30)); 
		
// -------------------------------------------------------------------------------------
		
	// no return, two parameter
		
		JustExecute je = (d,b) -> System.out.println(d+" "+b);
		
		je.execute("execute this", "sentence");
		
		
// -------------------------------------------------------------------------------------
		
	// no return, one parameter
	
		GetSum gs = (t,g) -> {
			
			return t+g;
		};
		
		GetSum gs1 = (y,h) -> y+h;
		
		System.out.println(gs.sum(4, 5));
		System.out.println(gs1.sum(6, 4));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
