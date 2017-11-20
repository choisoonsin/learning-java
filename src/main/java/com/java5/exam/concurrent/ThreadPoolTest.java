package com.java5.exam.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
   public static void main(String[] args) {
      int numWorkers = Integer.parseInt(args[0]);
      int threadPoolSize = Integer.parseInt(args[1]);

      ExecutorService pool = 
            Executors.newFixedThreadPool(threadPoolSize);
      WorkerThread[] workers = new WorkerThread[numWorkers];
      for (int i = 0; i < numWorkers; ++i) {
         workers[i] = new WorkerThread(i+1);
         pool.execute(workers[i]);
      }
      System.out.println("!!!!!!!!");
      pool.shutdown();
      System.out.println("@@@@@@@@");
   }
}
