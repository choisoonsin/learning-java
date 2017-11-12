package com.java8.exam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
		
		Arrays.asList("a1" , "a2" , "a3")
			.stream()  
			.findFirst() 
			.ifPresent(System.out::println);		// optional.class method 값이 있으면 값을 사용하여 지정된 소비자를 호출하고, 그렇지 않으면 아무 것도하지 않습니다.
		
		Arrays.stream(new int[]{1,2,3})
			.map( n -> 2 * n + 1)
			.forEach(System.out::println);
		
		Arrays.stream(new int[]{1,2,3})
			.map( n -> 2 * n + 1)
			.average()
			.ifPresent( n -> System.out.println(n));
			
		Stream.of("d2", "a2", "b1", "b3", "c")		// stream 객체의 map , filter(action) 은 laziness(늦은실행) operation을 갖는다. 
		    .filter(s -> {							// 실제 출력 하는 메소드(e.g. forEach) 실행 시점에 구동된다.
		        System.out.println("filter: " + s);
		        return true;
		    });
		
		System.out.println("-----------------------------------------------------------");
		
		Stream.of("d2", "a2", "b1", "b3", "c")		
		    .filter(s -> {							
		        System.out.println("filter: " + s);
		        return true;                       
		    })
		    .forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------");
		
		/*
		 * anyMatch
		 * 
		 * anyMatch 해당 객체를 찾은 후 종료된다.
		 * */
		Stream.of("d2", "a2", "b1", "b3", "c" , "a4")
			.map( s -> {
				System.out.println("map: "+s);
				return s.toUpperCase();
			})
			.anyMatch( s -> {
				System.out.println("anyMatch: "+s);
				return s.startsWith("A");
			});
			
		System.out.println("-----------------------------------------------------------");
		
		/*
		 * stream 객체는 재사용 할 수 없다. 사용되고 나면 스트림은 종료(closed)된다.
		 * */
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));	// 닫혀있지 않음. ( action 하지 않았으므로.. )
		
		stream.forEach(System.out::println);
		try {
			stream.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		System.out.println("-----------------------------------------------------------");	
		
		System.out.println("end");
		
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

