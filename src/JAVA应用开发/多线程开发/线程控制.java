package JAVA应用开发.多线程开发;

public class 线程控制 {
  public static void main(String[] args) throws InterruptedException {
    Download d = new Download();
    d.start();
    /*
     * Thread.sleep(1000);
     * d.suspend();
     * Thread.sleep(1000);
     * d.resume();
     */
    /*
     * Thread.suspend() 和 Thread.resume() 方法已经被弃用，
     * 因为它们容易导致死锁问题。
     * 建议使用更安全的线程控制方法，
     * 例如使用 wait() 和 notify() 或 Lock 和 Condition
     */
    /*
     * 死锁是一种常见的并发问题，发生在两个或多个线程相互等待对方释放资源，从而导致所有线程都无法继续执行。具体来说，死锁的四个必要条件是：
     * 
     * 互斥条件：每个资源要么已经分配给一个线程，要么是可用的。
     * 占有且等待：已经得到了某个资源的线程可以再请求新的资源。
     * 不可剥夺：线程已经获得的资源在未使用完之前不能被强制剥夺。
     * 循环等待：存在一个线程集合，其中每个线程都在等待集合中的另一个线程所占有的资源。
     */
    /* 解决： */
    Thread.sleep(1000);
    d.interrupt();
    Thread.sleep(1000);
    Download d1 = new Download();
    d1.start();
  }
}

class Download extends Thread {
  boolean run=true;
  static int i=1;
  public void run() {
    for (; i < 10 && run; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        if (Thread.interrupted()) {
          System.out.println("Thread was interrupted, stopping...");
          break;
        }
        e.printStackTrace();
      }
      System.out.println("下载音乐" + i);
    }
  }
}