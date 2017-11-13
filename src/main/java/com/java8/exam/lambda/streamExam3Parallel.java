package com.java8.exam.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class streamExam3Parallel {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
	
		ExecutorService excutor = Executors.newFixedThreadPool(5);
		
		List<Future<String>> futures = new ArrayList();
		for(int i =0 ; i < 50 ; i++) {
			final int index = i;		// final 확인
			futures.add(excutor.submit( () -> {
				Thread.sleep(1000);
				return Thread.currentThread().getName()+", index"+ index +", ended at "+ new Date();
			}));
		}
		
		for(Future<String> eachFuture : futures) {
			String result = eachFuture.get();
			System.out.println("Thread result:"+result);
		}
		excutor.shutdown();
		
		// java stream 의  parallel() 을 사용하여 병렬 처리
		IntStream.range(0 , 10)
			.parallel()
		    .forEach(index -> {
		    	System.out.println("Starting "+Thread.currentThread().getName()+", index="+index+", "+new Date());
		    	try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}
		    });
	}
	
}
