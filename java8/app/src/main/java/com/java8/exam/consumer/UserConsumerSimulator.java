package com.java8.exam.consumer;

public class UserConsumerSimulator {

	public static void main(String args[]){
		UserInterfaceConsumer<String> consumer = i -> System.out.println(i);
		consumer.accept("What");
		
		System.out.println(consumer.checkBytesLength("test"));
		
		UserInterfaceConsumer<Integer> intConsumer = i -> System.out.println(i);
		System.out.println(intConsumer.checkBytesLength(123));
		
		UserInterfaceConsumer<Object> objConsumer = i -> System.out.println(i);
		System.out.println(objConsumer.checkBytesLength(new Object()));
		
	}
}
