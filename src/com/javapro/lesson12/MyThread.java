package com.javapro.lesson12;

public class MyThread extends Thread {

  private final float[] tempArray;

  public MyThread(float[] tempArray) {
    this.tempArray = tempArray;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "start");
    for (int i = 0; i < tempArray.length; i++) {
      tempArray[i] = (float) (tempArray[i] * Math.sin(0.2f + i / 5.) * Math.cos(0.2f + i / 5.)
          * Math.cos(
          0.4f + i / 2.));
    }
    System.out.println(Thread.currentThread().getName() + "finish");
  }
}

