package JAVA应用开发.多线程开发;

public class 两种thread实现方法 {
  public static void main(String[] args) {
    player p = new player();
    Download d = new Download();
    p.start();
    d.start();
    /* 第二种 */
    PlayerRunnable p1 = new PlayerRunnable();
    DownloadRunnable d1 = new DownloadRunnable();
    Thread t1 = new Thread(p1);
    Thread t2 = new Thread(d1);
    t1.start();
    t2.start();
  }
}
class player extends Thread{
  public void run(){
    for(int i=0;i<10;i++){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt(); // Restore the interrupted status
      }
      System.out.println("播放背景音乐"+i);
    }
  }
}
class Download extends Thread{
  public void run(){
    for(int i=0;i<10;i++){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("下载音乐"+i);
    }
  }
}

/* 第二种方法：实现Runnable接口 */
class PlayerRunnable implements Runnable {
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt(); // Restore the interrupted status
      }
      System.out.println("播放背景音乐" + i);
    }
  }
}

class DownloadRunnable implements Runnable {
  // 实现Runnable接口
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("下载音乐" + i);
    }
  }
}
