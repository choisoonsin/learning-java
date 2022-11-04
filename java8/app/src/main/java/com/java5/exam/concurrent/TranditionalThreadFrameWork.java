package com.java5.exam.concurrent;

public class TranditionalThreadFrameWork {
	
	public static void main(String[] args){
		ThreadExam threadExam = new ThreadExam();
		threadExam.start();
		
		// counter 객체를 공유하는 두개의 스레드. counter 의 전역변수를 공유한다.
		Counter counter = new Counter();
	    Thread  threadA = new CounterThread(counter);
	    Thread  threadB = new CounterThread(counter);
	
	    threadA.start();
	    threadB.start(); 
	}
	
}

class ThreadExam extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ThreadExam run!!");
	}
}

class Counter{
    
    long count = 0;
   
    public synchronized void add(long value){
    	this.count += value;
    	System.out.println(Thread.currentThread().getName()+":"+count);
    }
    
}

class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
    	for(int i=1; i<5; i++){
    		counter.add(i);
    	}
    }
    
 }