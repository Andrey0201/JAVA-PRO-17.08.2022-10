package com.javapro.lesson12.model;

import java.util.Arrays;

public class ValueCalculator {

  private float[] array;
  private final int size = 500000;
  private final int halfSize = size / 2;

  public void doCalc() {
    long start = System.currentTimeMillis();
    System.out.println(Thread.currentThread().getName() + " start");
    array = new float[size];
    float[] array2 = new float[halfSize];
    float[] array3 = new float[halfSize];
    Arrays.fill(array, 5);

    System.arraycopy(array, halfSize, array2, 0, halfSize);
    System.arraycopy(array, halfSize, array3, 0, halfSize);

    getThreads(array2, array3);

    System.arraycopy(array2, 0, array, 0, halfSize);
    System.arraycopy(array3, 0, array, halfSize, halfSize);
    System.out.println(Thread.currentThread().getName() + " finish");
    long finish = System.currentTimeMillis() - start;
    System.out.println("runtime:" + finish + " ms");
  }

  private static void getThreads(float[] array2, float[] array3) {
    Thread thread = new MyThread(array2);
    Thread thread1 = new MyThread(array3);

    try {
      thread.start();
      thread1.start();
      thread.join();
      thread1.join();
    } catch (RuntimeException | InterruptedException e) {
      System.out.println("exception from thread");

    }
  }
}

