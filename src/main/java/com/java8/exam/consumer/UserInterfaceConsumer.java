package com.java8.exam.consumer;

@FunctionalInterface
public interface UserInterfaceConsumer<T> {

	void accept(T t);

	default int checkBytesLength(T t){
		return t.toString().getBytes().length;
	}
	
}
