package 动态性_接口_final;
/*
 * 动态多态性
 * -父类应用可以指向子类对象
 * -性质：父类应用调用重写成员时，调用子类成员非父类
 * 1.函数形参是父类应用，实参可以传入子类对象
 * void fun （dia d){d.show}
 * fun (new fontdia())//实际调用
 * 
 * fun可传入dialog的任何子类，d.show()的功能随子类变化
 * fun函数在不同子类传入，呈现不同功能，fun函数只写了1个，叫作动态多态性
 */

class dialog2 {
  public void show() {
  }
}

class fontdialog1 extends dialog2 {
  public void show() {
    System.out.println("fontdialog显示");
  }

  public static void main(String[] args) {
    dialog2 d = new fontdialog1();
    d.show();
  }
}

/* ------------------------------------------------- */
/*
 * class dialog2{
 * public void show(){};
 * }
 */
class fontdialog2 extends dialog2 {
  public void show() {
    System.out.println("dialog2显示");
  }
}

class window {
  public void click(dialog2 d) {
    d.show();
  }
}

/* 只能改自己的，不能改源代码 */
class newfontdialog extends dialog2 {
  public void show() {
    System.out.println("用户自己的dialog");
  }
}

/* 不能改源代码和 */
class beautifuldialog {
  public void display() {
    System.out.println("网上的dialog");
  }
}

class mydialog extends dialog2 {
  beautifuldialog bld = new beautifuldialog();

  public void show() {
    bld.display();
  }
}

/* 适配器模式，借壳上市 */
class test {
  public static void main(String[] args) {
    window w = new window();
    w.click(new newfontdialog());
  }
}
/*
 * 例子：某软件点击按钮出现字体对话框
 * 要求字体对话框支持用户定制，并不改变源代码
 */

/*
 * 2.函数返回父类类型，实际上返回子类对象
 * dialog fun(){
 * return new fontdialog();
 * }
 * //调用：dialog d=x.fun();d.show();
 */

/* ------------------------------------------------------ */

/*
 * 抽象类与抽象函数
 * -抽象函数用abstruct修饰，没有函数体
 * -抽象类，含有抽象函数的类，用abstruct修饰
 * 性质：
 * -抽象函数必须被正确重写，必须被重写！！！除非子类也是抽象类
 * -抽象类不能被实例化
 * -抽象类中可以有普通函数，被继承后使用
 */
/*
 * abstruct class dialog2{
 * public abstruct void show(){};//没有作用，提供所有子类标准化
 * void fun(){//...}
 * }
 * class fontdialog2 extends dialog2 {
 * public void show() {
 * System.out.println("dialog2显示");
 * }
 * }
 * 
 * class window {
 * public void click(dialog2 d) {
 * d.show();
 * }
 * }
 * 
 * class test {
 * public static void main(String[] args) {
 * window w = new window();
 * w.click(new newfontdialog());
 * new dialog();//错误！！！
 * }
 * }
 */

/* -------------------------------------------------------- */
/*
 * 接口：
 * -抽象类可以有普通函数，接口中全是抽象函数
 * -概念：interface 接口名称
 * -定义：继承接口用implements实现
 * -性质：
 * 1.通过，实现继承多个接口
 * 2.接口中都是public抽象函数,public abstruct可省；
 * 3.接口中定义的变量都是public static,无法对a进行加减，左值
 */
interface i1 {
  /* public */ int a = 5;

  /* public abstract */void fun1();
}

interface i2 {
  /* public */ int a = 6;

  // 报错
  /* public abstract */void fun1();
}

/* 若接口i1，i2有不同人编写，但都要实现，只能重写 */
class ji implements i1, i2 {
  public void fun1() {
  };

  public void fun2() {
  };

}

/* ------------------------------------------------------- */
/*
 * final关键字
 * -修饰变量，实际为常亮，必须定义时赋值之后不能赋值
 * -final修饰函数，函数不能在子类中重写
 * public void final fun(){}
 * -修饰类，类不允许有子类
 * public final class customer{}
 */