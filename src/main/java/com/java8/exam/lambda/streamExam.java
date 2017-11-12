package com.java8.exam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class streamExam {
	
	public static void main(String args[]){
		
		List<String> names = Arrays.asList("A" , "B" , "C");
		
		names.stream().filter( x -> !x.contains("A")).forEach( x -> System.out.println(x) );
		
		List<Person> persons = Arrays.asList(
	        new Person("a", 10),
	        new Person("b", 20),
	        new Person("c", 30)
        );
		
		List<Integer> numbers = Arrays.asList(1 , 2 , 3 , 4 , 5);
		
		Optional<Integer> result1 = numbers.stream().reduce( (x,y) -> Math.min(x, y));
		
		System.out.println(result1.toString());
		
		Optional<Integer> result2 = numbers.stream().reduce( (x,y) -> Math.max(x, y));
		
		System.out.println(result2.toString());
		
	}
	
	
}

class Person{

	private String name;
	private int age;
	
	public Person(String name , int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}