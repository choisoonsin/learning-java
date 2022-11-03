package com.java8.exam.consumer;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

import com.java.beans.Person;

public class SupplierSimulator {

	public static void main(String[] args) {

		Supplier<Person> supplier = () -> {
			return new Person("Choi" , 30 , "Programmer");
		};
		
		Person p = supplier.get();
		System.out.println("Person info : "+p.toString());
		
		// T type의 Supplier 외에 Int , long , boolean 등의 자료형별 Supplier 를 제공함. 
		IntSupplier intSupplier = () -> {
			return new Integer("30");
		};
		
		int s = intSupplier.getAsInt();
		System.out.println("s:"+s);
		
		/** When we should use Supplier in java8 ?**/
		/*
		 *  What difference between this code?

			Supplier<LocalDate> s1 = LocalDate::now;
			LocalDate s2 = LocalDate.now();
			
			System.out.println(s1.get()); //2016-10-25
			System.out.println(s2); //2016-10-25

		 * */
		//Answer - stackoverflow
		/*
		 * Let's assume you have a class named MyAmazingClass, 
		 * and you have a method in it with the name  MyEvenBetterMethod (which is static), 
		 * and you need to call it 15 times at 15 different positions in your code. 
		 * Of course, you can do something like...

			int myVar = MyAmazingClass.MyEvenBetterMethod();
			// ...
			int myOtherVar = MyAmazingClass.MyEvenBetterMethod();
			// And so on...
			
			...but you can also do
			
			Supplier<MyAmazingClass> shorter = MyAmazingClass::MyEvenBetterMethod;
			
			int myVar = shorter.get();
			// ...
			int myOtherVar = shorter.get();
			// And so on...
		 * */
		
	}

}
