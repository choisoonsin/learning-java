package com.java8.exam.lambda;

import java.util.Arrays;
import java.util.List;

public class streamExam2 {
	
	public static void main(String args[]){
		
		List<String> myList = Arrays.asList("a1" , "a2" , "b1" , "b2" , "c1" , "c2");
		
		myList.stream()		// List 객체를 stream 형태로 변환
			  .filter( x -> x.startsWith("c"))		// 함수형 인터페이스 @FunctionalInterface 에는 메서드가 하나만 있어야 함. 
			                                        // filter param의 predicate는 default mothod 를 제외한 boolean test 객체만 존재함.
		      .map( x -> x.toUpperCase())			// 1.8 에서는 String::toUpperCase 로 표현할수 있다.
		      .sorted( (x,y) -> x.compareTo(y) )
		      //.forEach(System.out::println);
		      .forEach(Test.decorator::printDeco)	// Test class 적용. ::(double colon) 표현법(java 1.8) , 
		                                            // forEach 에 들어오는 param을 "detects" 하여 param 인자 수 , 형태에 따라 자동 바인딩
		      										// e.g. Math::max >> 의 경우 max(int i , int j) 형태를 인지하여 forEach에서 해당 값이 기대됬을때 자동처리(?) 됨.
		      ;
		
	}
	
}
/*
 * filterClass 만들기
 * 
 * 싱글톤으로 생성. private 생성자.
 * */
final class Test{
	 
	private Test() {
		// TODO Auto-generated constructor stub
	}
	
	public final static Test decorator = new Test();
	
	public void printDeco(String x){
		System.out.println("["+x+"]");
	}
	
}

