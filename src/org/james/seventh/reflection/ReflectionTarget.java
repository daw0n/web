package org.james.seventh.reflection;

public class ReflectionTarget {
	private String test1;
	private String test2;
	private String test3;
	public static final String test4 = "TEST4";
	
	public ReflectionTarget() {
		test1 = "TEST1 By Reflection";
		test2 = "TEST2 By Reflection";
		test3 = "TEST3 By Reflection";
		
		printTest1(test1);
		printTest2(test2);
		printTest3(test3);
	}
	
	public ReflectionTarget(String test1, String test2, String test3) {
		printTest1(test1);
		printTest2(test2);
		printTest3(test3);
	}
	
	public void printTest1(String test1) {
		System.out.println(test1);
	}
	public void printTest2(String test2) {
		System.out.println(test2);
	}
	public void printTest3(String test3) {
		System.out.println(test3);
	}
}
