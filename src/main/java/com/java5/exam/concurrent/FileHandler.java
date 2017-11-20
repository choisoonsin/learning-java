package com.java5.exam.concurrent;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileHandler implements Runnable{

	private String filePath;
	private String movePath;
	private final File FILE;
	
	FileHandler(String filePath , String movePath) throws Exception{
		this.filePath = filePath; 
		this.movePath = movePath;
		this.FILE = new File(filePath);
		
		if(!FILE.isDirectory()) {
			throw new Exception("Please put the directory into param");
		}
	}
	
	@Override
	public void run() {
		System.out.println("invoked call()");
		try {
			startDaemon();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startDaemon() throws InterruptedException {
		// Daemon
		while(true) {
	
			deleteFile();
			Thread.sleep(1000);
			
		}
	}
	
	private synchronized void deleteFile() throws InterruptedException {
		System.out.println("["+Thread.currentThread().getName()+" for start!");
		File[] files = FILE.listFiles();
		for(File file:files) {
			if(file.isFile()) {
				System.out.println("["+Thread.currentThread().getName()+"] delete file = "+file.getName());
				file.delete();
			}
			Thread.sleep(1000);
		}
		System.out.println("["+Thread.currentThread().getName()+" for ended!");
	}
	
	private synchronized InputStream getFile(File file) throws FileNotFoundException {
		return new BufferedInputStream(new FileInputStream(file));
	}

}
