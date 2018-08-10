package xyz.jeevan.code.concurrancy;

public class ProcessorTest {

  public static void main(String[] args) throws InterruptedException {
    Processor processor = new Processor();

    Thread thread1 = new Thread(processor, "T1");
    thread1.start();

    Thread thread2 = new Thread(processor, "T2");
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("Count - " + processor.getCount());
  }

}
