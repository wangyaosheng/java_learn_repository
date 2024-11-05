package JAVA应用开发.常用API.lang;
public class lang包 {
  /*
   * API:应用编程接口：java框架内置的一些类或函数，供应用开发时调用
   * java提供的数值计算
   * -使用java文档https://docs.oracle.com/javase/8/docs/api/
   * -java.lang.Math类
   * -java.lang包：java核心包，包含核心API接口，可直接使用
   * java提供的字符串处理
   * -java.lang.String
   * --用equals 判断两个字符穿是否相等
   * --用string各个成员函数处理字符串
   * -判断一个字符串中出现几个北京
   * --用split将之分割，切成几段有几段-1，注意开头结尾
   * -java.lang.StringBuffer
   * --非自变型字符串
   * java提供的数据类型转换
   * -字符串转数值：
   * --各种数值类型的包装类：java.lang.Integer是int类型的包装类，同理其余类型
   * -数值转字符串：
   * --String.valueOf(数值):任何类型
   * 
   */
  static int setage(int age) throws Exception {
    if (age < 0 || age > 100) {
      throw new Exception("年龄错误");
    }
    return age;

  }

  public static void main(String[] args) {
    System.out.println(Math.PI);
    System.out.println(Math.cos(Math.toRadians(30)));
    // 角度转弧度制
    String str1 = "csu2";
    String str2 = "csu2";
    String str3 = new String("csu2");
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);
    // str1和str2是一个对象，指向同一个csu2,但str3不是
    System.out.println(str1.equals(str3));
    StringBuffer str = new StringBuffer("dddd北京dddd北京");
    str.append("中国");
    // 可直接对自己变形操作，但普通string不行
    /*
     * 练习1：编写1个函数setAge( int), 输入一个年龄,
     * 如果在0-100之间， 该函数返回年龄数值，
     * 否则返回“年龄错误”。返回的内容应该可被调用方使用
     */
    try {
      int age = lang包.setage(1000);
      System.out.println(age);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    /*
     * ！！！！异常信息链式传递
     * 或是链式传递
     * public static void main(String[] args) throws Exception{
     * // 函数不处理异常，把异常抛出给调用他的函数，即main函数接受
     * int age=常用API.setage(1000);
     * System.out.println(age);
     * }
     */
  }

}
