package com.java5.exam.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThreadPoolTest {
	public static void main(String[] args) {
      int numWorkers = Integer.parseInt(args[0]);

      ExecutorService pool = Executors.newCachedThreadPool();
      CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
      Future[] futures = new Future[numWorkers];
 
      for (int i = 0; i < numWorkers; ++i) {
         workers[i] = new CallableWorkerThread(i + 1);
         futures[i] = pool.submit(workers[i]);		// Callable 객체는 ExcutorService의 submit을 호출하여 실행한다. ( Runnable 객체 실행의 경우 excute )
      }
      for (int i = 0; i < numWorkers; ++i) {
         try {
            System.out.println(futures[i].get() + " ended");
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         } catch (ExecutionException ex) {
            ex.printStackTrace();
         }
      }
   }
}
