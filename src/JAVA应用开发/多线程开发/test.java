package JAVA应用开发.多线程开发;
/* 两个线程，向同一个数组arr[4]中寻访数据，要求按照顺序存放，分别为1,2,3,4 */
public class test implements Runnable{
  int []a=new int[4];
  int index=0;
  public void run(){
    while(true){
      /* 在this上打标签上锁，不让别人进来，运行完后this上标签自行消失 */
      synchronized(this){
      if(index==4){
        break;
      }
      a[index]=index+1;
      
      System.out.println(Thread.currentThread().getName()+"a"+index+"放入"+index+1);
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      index++;
    }}
  }
  public static void main(String[] args) {
    test t=new test();
    Thread t1= new Thread(t);
    Thread t2=new Thread(t);
    t1.start();
    t2.start();
    
  }
}
