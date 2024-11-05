# javaIO操作：java.io
  *IO:输入输出:输入输出设备是站在内存角度划分*
 ## 最常见的输入输出单元：文件
  * 如何表述：java.io,file类
 ``` JAVA
import java.io.File;
public class java_io {
  public static void main(String[] args) {
    File file = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/java_io.md");
    System.out.println("文件名：" + file.getName());
    System.out.println("文件路径：" + file.getPath());
    System.out.println("文件绝对路径：" + file.getAbsolutePath());
    System.out.println("文件父路径：" + file.getParent());
    File file2 = new File("abc.txt");
    file2.createNewFile();
    file2.delete();
    System.out.println("文件是否存在：" + file.exists());
    System.out.println("文件是否可写：" + file.canWrite());
    System.out.println("文件是否可读：" + file.canRead());
    System.out.println("文件是否是一个目录：" + file.isDirectory());
    System.out.println("文件是否是一个文件：" + file.isFile());
    System.out.println("文件最后修改时间：" + file.lastModified());
    System.out.println("文件大小：" + file.length());
    System.out.println("是否成功删除文件：" + file.delete());
  }
}
 ```
  *  例子：列出C盘下所有文件和文件夹
```JAVA
import java.io.File;
public class java_io {
  public static void main(String[] args) {
    File file = new File("/Users/wangyaosheng/");
    for (File f : file.listFiles()) {
      System.out.println(f);
    }
  }
}
 ```
* 支持：文件删除，增加，重命名 不支持复制，移动

## 读文件 ：将硬盘上的文件读入到内存进行处理 FileInputStream
* 例子：本文件夹中有一个testl.txt,请将其读入后显示在屏幕
 ```JAVA
import java.io.FileInputStream;
public class java_io {
  public static void main(String[] args) {
 File f=new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作");
    try (FileInputStream fis = new FileInputStream(f)) {
        byte[] all = new byte[(int) f.length()];
        fis.read(all);
        String content = new String(all);
        System.out.println("文件内容：\n" + content);
    }
  }
}
 ```
 * 仅仅支持字节流，不支持双字节字符（汉字）

```JAVA
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class java_io {
  public static void main(String[] args) {
    File f = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作");
    try (FileInputStream fis = new FileInputStream(f)) {
      // 创建一个字节数组，其大小为文件的长度
      byte[] all = new byte[(int) f.length()];
      // 读取文件内容到字节数组
      fis.read(all);
      // 将字节数组转换为字符串
      String content = new String(all);
      System.out.println("文件内容：\n" + content);
      
      // 循环读取文件内容，直到文件末尾
      while (true) {
        int i = fis.read();
        if (i == -1) {
          break;
        }
        System.out.println(i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```
 
 * 双字节字符使用 FileReader

```JAVA
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_io {
  public static void main(String[] args) {
    try {
      // 创建一个新的文件对象
      File f2 = new File("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/abc.txt");
      // 创建新文件
      f2.createNewFile();
      // 创建一个FileReader对象，用于读取文件内容
      FileReader fr = new FileReader(f2);
      // 循环读取文件内容，直到文件末尾
      while (true) {
        int i = fr.read();
        if (i == -1) {
          break;
        }
        // 输出读取的字符
        System.out.println((char) i);
      }
      // 关闭FileReader
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
 ```
## 写文件：将一些内容保存在文件中 FileWriter OutputStream

* 例：将”CSU使中南大学“写入text.txt中
```JAVA
import java.io.FileWriter;
import java.io.IOException;

public class java_io {
  public static void main(String[] args) {
    try {
      // 创建一个FileWriter对象，用于向文件中写入数据
      FileWriter fw = new FileWriter("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/text.txt");
      // 写入字符串到文件
      fw.write("CSU使中南大学");
      // 关闭FileWriter
      fw.close();
      System.out.println("写入成功");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```
* 使用OutputStream写文件

```JAVA
import java.io.FileOutputStream;
import java.io.IOException;

public class java_io {
  public static void main(String[] args) {
    try (FileOutputStream fos = new FileOutputStream("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/text.txt")) {
      // 写入字符串到文件
      String content = "CSU使中南大学";
      fos.write(content.getBytes());
      System.out.println("写入成功");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

* 例：讲一个文件t1.txt内容进行加密，加密规则：每个字节的数字加3，比如：China加密后程Fklgd,变成t2.txt
```JAVA
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_io {
  public static void main(String[] args) {
    try {
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
  }
}
```
**加密算法+秘钥 使加密体系的两大因素**

* 例：讲一个图像image1.jpg内容进行加密，加密规则：每个字节的数字加3，变成image2.jpg

## 将长文本按行读的类 BufferedReader
```JAVA
  BufferedReader br = new BufferedReader(new FileReader("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt"));
    while(true){
      String line = br.readLine();
      if(line==null){
        break;
      }
      System.out.println(line);
    }
```

## 可以丰富格式写的类 PrintStream
 * 将一个99乘法表写入t1.txt
```JAVA
 PrintStream ps = new PrintStream(new FileOutputStream("/Users/wangyaosheng/Desktop/code/javacode/java_class java/src/JAVA应用开发/JAVA_IO操作/t2.txt"));
    for(int i=1;i<10;i++){
      for(int j=1;j<=i;j++){
        //打印i*j=i*j
        ps.print(" "+i+"*"+j+"="+i*j);
      }
    }
```
### printstream类和System.out功能为什么像？
  System.out 是 printstream类的对象

## 可以任意从文件的某个位置开始读写的类： java.io.RandomAccessFile类
  *seek 方法是 RandomAccessFile 类中的一个重要方法，用于将文件指针移动到文件中的指定位置。文件指针决定了下一次读写操作将发生的位置。