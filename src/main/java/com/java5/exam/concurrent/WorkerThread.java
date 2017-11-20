package com.java5.exam.concurrent;

public class WorkerThread implements Runnable {
   private int workerNumber;

   WorkerThread(int workerNumber) {
      this.workerNumber = workerNumber;
   }

   public void run() {
      // The thread simply prints 1 to 5
      for (int i = 1; i <= 5; ++i) {
         System.out.printf("Worker %d: %d\n", workerNumber, i);
         try {
            // sleep for 0 to 0.5 second
            Thread.sleep((int)(Math.random() * 1000));
         } catch (InterruptedException e) {}
      }
   }
}
