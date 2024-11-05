package JAVA应用开发.JAVA_IO操作;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;

public class java_io {
  public static void main(String[] args) throws Exception/* 注意：出错时 */ {
    /*
     * File file = new
     * File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/java_io.md"
     * );
     * System.out.println("文件名：" + file.getName());
     * System.out.println("文件路径：" + file.getPath());
     * System.out.println("文件绝对路径：" + file.getAbsolutePath());
     * System.out.println("文件父路径：" + file.getParent());
     * File file2 = new File("abc.txt");
     * file2.createNewFile();
     * file2.delete();
     * System.out.println("文件是否存在：" + file.exists());
     * System.out.println("文件是否可写：" + file.canWrite());
     * System.out.println("文件是否可读：" + file.canRead());
     * System.out.println("文件是否是一个目录：" + file.isDirectory());
     * System.out.println("文件是否是一个文件：" + file.isFile());
     * System.out.println("文件最后修改时间：" + file.lastModified());
     * System.out.println("文件大小：" + file.length());
     * System.out.println("是否成功删除文件：" + file.delete());
     * for (String s : file.list()) {
     * System.out.println(s);
     * } // 列出文件夹下所有文件
     * for (File f : file.listFiles()) {
     * System.out.println(f);
     * } // 列出文件夹下所有文件
     */
/*     File f = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作");
    FileInputStream fis = new FileInputStream(f);
    byte[] all = new byte[(int) f.length()];
    fis.read(all);
    String content = new String(all);
    System.out.println("文件内容：\n" + content);
    fis.close();

    while (true) {
      int i = fis.read();
      if (i == -1) {
        break;
      }
      System.out.println(i);
    }

    File f2 = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/abc.txt");
    f2.createNewFile();
    FileReader  fr = new FileReader(f2);
    while(true){
      int i = fr.read();
      if(i==-1){
        break;
      }
      System.out.println((char)i);
    } */
   try {
     File f = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t1.txt");
      f.createNewFile();
      File f2 = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt");
      f2.createNewFile();
      // 创建文件输入流，读取t1.txt文件
      FileInputStream fis = new FileInputStream("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t1.txt");
      // 创建文件输出流，写入t2.txt文件
      FileOutputStream fos = new FileOutputStream("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt");
      
      int b;
      // 循环读取文件内容
      while ((b = fis.read()) != -1) {
        // 每个字节加3后写入输出流
        fos.write(b + 3);
      }
      
      // 关闭输入输出流
      fis.close();
      fos.close();
      
      System.out.println("加密完成");
    } catch (IOException e) {
      e.printStackTrace();
    }

    BufferedReader br = new BufferedReader(new FileReader("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt"));
    while(true){
      String line = br.readLine();
      if(line==null){
        break;
      }
      System.out.println(line);
    }

    PrintStream ps = new PrintStream(new FileOutputStream("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt"));
    for(int i=1;i<10;i++){
      for(int j=1;j<=i;j++){
        //打印i*j=i*j
        ps.print(" "+i+"*"+j+"="+i*j);
      }
    }
  }
}
