package com.java8.exam.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ComsumerSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> consumer = ComsumerSimulator::printNames;
		
		consumer.accept("terry");
		consumer.accept("Storm");
		consumer.accept("Rain");
		
		System.out.println();
		
		Consumer<Integer> intConsumer = i -> System.out.println("["+i+"]");
		List<Integer> integerList = Arrays.asList(new Integer(1) , new Integer(10) , new Integer(100) , new Integer(200));
		
		printList(integerList , intConsumer);
		
		System.out.println();
		// checkLength 메소드를 사용하여 파라메터 소비(consume)
		Consumer<String> nameConsumer = s -> checkLength(s);
		// checkLength 소비 후  sysout 하여 파라미터 처리
		Consumer<String> nameConsumerAndThen = nameConsumer.andThen( s -> System.out.println("andThen ["+s+"]"));
		
		nameConsumerAndThen.accept("Bobby");
		nameConsumerAndThen.accept("Chocolate");
		
	}
	
	private static void printNames(String name){
		System.out.println(name);
	}
	
	private static void printList(List<Integer> listOfIntegers , Consumer<Integer> consumer){
		for(Integer integer : listOfIntegers){
			consumer.accept(integer);
		}
	}
	
	private static void checkLength(String name){
		System.out.println(name+" length:"+name.getBytes().length);
	}

}
