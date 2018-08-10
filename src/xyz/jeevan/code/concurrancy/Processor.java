package xyz.jeevan.code.concurrancy;

public class Processor implements Runnable {

  private int count;

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      processSomething(i);
      count++;
    }
  }

  public int getCount() {
    return this.count;
  }

  private synchronized void processSomething(int i) {
    try {
      Thread.sleep(i * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}