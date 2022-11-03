package com.java5.exam.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileHandlerSimulator {

	public static void main(String args[]) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		// 다음 처럼 쓰레드에서 실행 시킬 객체를 각각 생성하는 경우 class object 를 공유 할 수 없음.
		FileHandler workers[] = new FileHandler[2];
	    for(int i = 0 ; i < 2 ; i++) {
	    	try {
				workers[i] = new FileHandler("C:\\files\\" , "C:\\targetFiles");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	service.execute(workers[i]);
	    }
		
	}
	
}
