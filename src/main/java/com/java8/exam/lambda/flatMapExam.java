package com.java8.exam.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class flatMapExam {
	
	public static void main(String args[]){
		
		String[][] data = new String[][]{{"a" , "b"} , {"c" , "d"} , { "e" , "f"}};
		
		Stream<String[]> convData = Arrays.stream(data);
		
		convData.forEach( x-> System.out.println(x));
	}
	
}