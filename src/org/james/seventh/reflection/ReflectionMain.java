package org.james.seventh.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionMain {
	private static final String star = " ********** ";
	public ReflectionMain() throws Exception{
		Class c = Class.forName("org.james.seventh.reflection.ReflectionTarget");
		
		printMethodName(c);
		printDataFields(c);
		printConstructorName(c);
		executeClass(c);
	}
	public void printMethodName(Class clazz) {
		printTitle("printMethodName");
		Method[] allM = clazz.getMethods();
		Method[] declaredM = clazz.getDeclaredMethods();
		String name = "";
		
		for(int i = 0; i<allM.length; i++) {
			name = allM[i].getName();
			
			if(i<declaredM.length) {
				System.out.println(name + "/" + declaredM[i].getName());
			}else {
				System.out.println(name);
			}
		}
		printBlank();
	}
	
	public void printDataFields(Class clazz) {
		printTitle("printDataFields");
		Field[] df = clazz.getDeclaredFields();
		String name = "";
		
		for(int i = 0; i<df.length; i++) {
			name = df[i].getName();
			System.out.println(name);
		}
		printBlank();
	}
	
	public void printConstructorName(Class clazz) {
		printTitle("printConstructorName");
		Constructor[] dcs = clazz.getDeclaredConstructors();
		String name = "";
		
		for(int i = 0; i<dcs.length; i++) {
			name = dcs[i].getName();
			
			System.out.println(name);
			Parameter[] params = dcs[i]. getParameters();
			for(int j = 0; j<params.length; j++) {
				System.out.println("\t" + params[j].getName());
			}
		}
		printBlank();
	}
	
	public void executeClass(Class clazz) throws Exception{
		printTitle("executeClass");
		clazz.newInstance();
	}
	
	public static void main(String[] args) throws Exception{
		new ReflectionMain();
	}
	public void printTitle(String title) {
		System.out.println(star + title + star);
	}
	public void printBlank() {
		System.out.println("\n\n\n");
	}

}
