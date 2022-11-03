package com.java5.exam.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileHandlerSimulator {

	public static void main(String args[]) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		// ���� ó�� �����忡�� ���� ��ų ��ü�� ���� �����ϴ� ��� class object �� ���� �� �� ����.
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
