package 继承_覆盖_组合;
/*
 * 继承
 * 公共代码分别写每个对话框
 * -将公共代码写成父类，每个对话框写成子类来继承父类
 * -编程实现：子类用extends继承父类
 * -继承性质：
 * -1.子类从父类继承的成可直接使用，私有成员无法继承
 * -2.子类继承父类，父类又叫做超类。基类。子类有名派生类，扩展类
 * -3.java中类只支持单冲继承，一个类不能同时继承多个类
 * 
 * 覆盖-override(重写）：
 * -子类中是否可定与父类相同成员
 * -可以，覆盖后子类对象调用的子类成员，父类无
 * -作用是可支持子类个性化
 * -覆盖中子类成员访问权限不允许比父类更严格
 * -只对成员函数适用，成员变量不适用！！！！
 * 
 * 继承的本质：子类实例化前会自动调用父类构造函数，为其生成对应的父类对象
 * 子类继承父类，实际上市子类和父类的组合关系
 * 
 * super:子类对象中对相应父类对象的用名，this是对自己的应用名
 * 
 * 组合：多个类合作完成工作
 * 类别：（从强到弱）
 * -1.继承：子类实例化，父类提前实例化，子类对象消亡，相应的父类对象消亡
 * -2.生命周期组：
 *    class A()
 *    class B(){
 *     A a=new A();
 *     //...
 * }
 * -3.暂时组合：
 *    class A()
 *    class B(){
 *     
 *     void fun(){A a=new A();使用A的功能}
 * }
 */

/**
 * sixth_class
 */
public class sixth_class {
  public static void main(String[] args) {
    fontdialog fd = new fontdialog(0, 0);
    fd.w = 199;
    fd.show();

    new fontdialog(0, 0);
    new paradialotg();
    /* 这里会调用2次父类构造函数 */
  }

}

class dialog {
  int w;
  int h;
  public String bgcolor = "red";// 这里可以

  // 不允许父类是public,子类是私有或protected
  public void show() {
    System.out.println("界面显示,w=" + w);
  }

  dialog(int w, int h) {
    this.w = w;
    this.h = h;
    /* 父类构造函数参数与子类保持一致 */
    System.out.println("dialog实例化");
  }
}

class fontdialog extends dialog {
  String bgcolor = "green";
  int fontsize;

  fontdialog(int a, int b) {
    /*
     * 使用super调用父类构造函数
     * 写在第一句！！！
     */
    super(40, 50);
    System.out.println("fontdialog实例化");
  }
}

class paradialotg extends dialog {

  int linewidth;

  paradialotg() {
    super(40, 50);
    System.out.println("paradialog实例化");
  }

}

/*
 * 连习：一个类A，要同时复用两个类里的。。。
 * 
 * class A;
 * class B
 * Class C()extends B{
 * A a=new A()
 * //通过a.X用A中成员
 * }
 * 
 * class A;
 * class B
 * Class C(){
 * A a=new A()
 * B b=new B()
 * 、、
 * }
 */

/*
 * 练习：某软件（图像处理）需要实现四个功能，在网上下载了一个软件包包含4个工能，
 * 但：功能1要增加其他代码，2不安全，要屏蔽，3要更换，4不变
 * 不能修改源代码
 * 注：最好不改名，可用继承或是组合
 */
class imageope {
  public void fun1() {
    System.out.println("功能1");
  }

  public void fun2() {
    System.out.println("功能2");
  }

  public void fun3() {
    System.out.println("功能3");
  }

  public void fun4() {
    System.out.println("功能4");
  }
}

class myimageope extends imageope {
  public void fun1() {
    super.fun1();
    System.out.println("增加代码");
  }

  public void fun2() {

  }

  public void fun3() {
    System.out.println("更换后的代码");
  }
  /*
   * 用组合写：fun4必须再写
   * class myimageope extends imageope {
   * imageope io=new imageope()；
   * public void fun1() {
   * .fun1();
   * System.out.println("增加代码");
   * }
   * public void fun3() {
   * System.out.println("更换后的代码");
   * }
   * public void fun4() {
   * io.fun4();
   * }
   */

  /*
   * 可不写，已存在
   * public void fun4() {
   * super.fun4();
   * }
   */
}

/*
 * 什么时候用继承，组合
 * 本质都是为了增加复用性，如果复用的内容涉及到各类的共同特征和功能，用继承
 * 如果仅仅只是合作，用组合
 */

