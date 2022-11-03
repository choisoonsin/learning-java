package com.java5.exam.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileHandlerSimulator2 {

	public static void main(String args[]) throws Exception {
		 
		ExecutorService service = Executors.newFixedThreadPool(2);
		 
		// 쓰레드 pool 객체 간 object 공유 시
		FileHandler workers = new FileHandler("C:\\files\\" , "C:\\targetFiles");
	    for(int i = 0 ; i < 2 ; i++) {
	    	service.execute(workers);
	    }
		
	}
	
}
