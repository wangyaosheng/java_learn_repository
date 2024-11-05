package 分装;



public class fifth_class {

  /*
   * 分装（encapsulation) :影藏模块细节，讲可用功能展示给客户
   * 1. 包级分装（文件放在文件夹里）
   * 将类用包（package)来管理
   * 如何将一个类放在某个包里？
   * 在类的定义前标记包名（:p...)即可
   * 包名一般为名词，首字母小写
   * 包名可用.隔开，编译时据点号生成子文件夹
   * 点号隔开不代表隶属关系
   * bank与bank.p是两个不同的包，导入bank中得类不会影响bank.p
   * 如何使用包中得类
   * 同一个包中得类可直接使用
   * 不同包中的类，可import "包名.类名"，或者import "包名."访问。
   * 前提：public类
   * 
   * 2.类级分装
   * 普通类： class XX()：只能在一个包内访问
   * public类 pubic classXX():可在包外访问
   * -类名和类所在文件名必须相同
   * 
   * 3.成员级分装：在成原定义前加上访问控制符
   * -private private double s
   * private 成员只能在类内部使用
   * -默认 String a
   * 成员类所在的同一个包使用
   * -protected protected int s
   * 成员类所在的同一个包使用，也能在包外子类使用
   * -public public void showz()
   * 成员能在包内包外使用
   * 建议：将成员变量定义为private, 成员函数定义为public
   * 要被子类访问的成员变量可以定义为protected,不被外界访问的函数可定义为private
   */

}

class customer {
  String account;
};

/*
 * 3.很多操作要求：内存中对象个数不超过1个
 * eg.只打开一个内存管理器
 */
/* ！！！！单例模式化 */
class desktop {
  /* taskmanager tm = new taskmanager();// 第三种：在类初始化时会预加载，若很多的话会很耗时 */
  /* taskmanager tm =null;//第二种 */
  public void click() {
    taskmanager tm = taskmanager.getinstance();
    tm.show();
    /* taskmanager tm.show();//第四种： */
    /* if(tm=null) tm = new taskmanager();////第二种：使desktop代码受到污染 */
    /* taskmanager tm = new taskmanager();//第一种：会造成多次实例化 */

  }

  public static void main(String[] args) {
    desktop d = new desktop();
    d.click();
    d.click();
    d.click();
    d.click();
  }
}

class taskmanager {
  /* public static taskmanager tm=new taskmanager();//第四种： */
  private static taskmanager tm = new taskmanager();

  // 第六种：改为private
  public static taskmanager getinstance() {
    return tm;
  }

  /* 第五种：改为私有构造函数 */
  private taskmanager() {
    System.out.println("taskmanager实例化");
  }

  public void show() {
    System.out.println("taskmanager 显示");
  }
}

/*
 * 在 Java 中，单例模式（Singleton
 * Pattern）是一种设计模式，它确保一个类只有一个实例，并且提供全局访问点来访问该实例。实现单例模式有多种方式，最常见的几种包括饿汉式、懒汉式、
 * 双重检查锁（DCL）以及静态内部类方式。
 * 
 * 下面是各种单例模式的实现方式：
 * 
 * ### 1. **饿汉式单例**
 * 饿汉式单例模式在类加载时就创建实例，因此线程安全，但如果单例类的实例较大或者使用不频繁，会造成内存浪费。
 * 
 * ```java
 * public class Singleton {
 * // 静态实例，在类加载时就初始化
 * private static final Singleton instance = new Singleton();
 * 
 * // 私有构造方法，防止外部实例化
 * private Singleton() {}
 * 
 * // 提供公共静态方法获取唯一实例
 * public static Singleton getInstance() {
 * return instance;
 * }
 * }
 * ```
 * 
 * ### 2. **懒汉式单例**
 * 懒汉式单例模式是在第一次使用时才创建实例。此实现方式存在线程安全问题，在多线程环境下可能会产生多个实例，因此需要加锁。
 * 
 * ```java
 * public class Singleton {
 * // 静态变量保存唯一实例
 * private static Singleton instance;
 * 
 * // 私有构造方法
 * private Singleton() {}
 * 
 * // 提供公共方法获取实例，并通过 synchronized 关键字加锁以确保线程安全
 * public static synchronized Singleton getInstance() {
 * if (instance == null) {
 * instance = new Singleton();
 * }
 * return instance;
 * }
 * }
 * ```
 * 
 * ### 3. **双重检查锁（Double-Checked Locking）**
 * 双重检查锁在懒汉式基础上进行了优化，减少了使用 synchronized 的频率，仅在第一次实例化时加锁，提高了性能。
 * 
 * ```java
 * public class Singleton {
 * // 使用 volatile 关键字保证可见性
 * private static volatile Singleton instance;
 * 
 * // 私有构造方法
 * private Singleton() {}
 * 
 * // 提供公共方法获取实例，双重检查锁保证线程安全
 * public static Singleton getInstance() {
 * if (instance == null) {
 * synchronized (Singleton.class) {
 * if (instance == null) {
 * instance = new Singleton();
 * }
 * }
 * }
 * return instance;
 * }
 * }
 * ```
 * 
 * ### 4. **静态内部类单例**
 * 静态内部类方式是推荐的单例实现方式，利用了类加载机制来保证线程安全，同时实现了懒加载。
 * 
 * ```java
 * public class Singleton {
 * // 私有构造方法
 * private Singleton() {}
 * 
 * // 静态内部类持有 Singleton 实例，只有在 getInstance 方法调用时才会被加载
 * private static class SingletonHolder {
 * private static final Singleton INSTANCE = new Singleton();
 * }
 * 
 * // 提供公共方法获取实例
 * public static Singleton getInstance() {
 * return SingletonHolder.INSTANCE;
 * }
 * }
 * ```
 * 
 * ### 5. **枚举实现单例**
 * 使用枚举类来实现单例是 Java 提供的最佳实现方式，天然支持线程安全和防止反序列化生成新对象。
 * 
 * ```java
 * public enum Singleton {
 * INSTANCE;
 * 
 * public void someMethod() {
 * // 执行单例方法
 * }
 * }
 * ```
 * 
 * ### 6. **防止反射与反序列化破坏单例**
 * 单例模式可能会被反射或反序列化破坏。解决这个问题可以通过以下方式：
 * - **防止反射破坏**：在构造函数中抛出异常，防止多次实例化。
 * - **防止反序列化破坏**：实现 `readResolve` 方法。
 * 
 * ```java
 * public class Singleton {
 * private static final Singleton instance = new Singleton();
 * 
 * private Singleton() {
 * // 防止反射实例化
 * if (instance != null) {
 * throw new IllegalStateException("Already instantiated");
 * }
 * }
 * 
 * public static Singleton getInstance() {
 * return instance;
 * }
 * 
 * // 防止反序列化破坏单例
 * private Object readResolve() {
 * return instance;
 * }
 * }
 * ```
 * 
 * ### 选择单例模式的注意事项
 * - **饿汉式**：简单实现但浪费内存，适合实例化成本较低的场景。
 * - **懒汉式**：线程安全问题较多，不推荐。
 * - **双重检查锁**：懒加载并且效率高，推荐在性能要求较高的场景。
 * - **静态内部类**：推荐使用的懒加载单例模式。
 * - **枚举实现**：最佳实践方式，强烈推荐。
 */

/*
 * 练习2：将成员变量定义为private的， 如果在累的外部被访问做法：
 * 通过public函数访问，函数中含有对该成员变量的访问进行检查和限制的代码：可以使用set和get 函数：
 */
class customer1 {
  private String account;
  private String password, cname;
  private double balance;

  public void setbalance(double balance){
    this.balance=balance;
  }
  
/* 在此检查权限 */
  public void setaccount(String account){
    this.account=account;
  }
  public String getaccount(){
    return this.account;
  }
}

class manager{
  public static void main(String[] args) {
    customer c=new customer();

  }
}