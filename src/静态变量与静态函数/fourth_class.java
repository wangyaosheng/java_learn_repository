
package 静态变量与静态函数;
public class fourth_class {
    /*
     * 静态变量
     * -一个类可以实例化多个对象，每个对象的成员变量各自占用内存
     * -所有对象公用内存的成员变量，将该变量定义为静态变量，加static修饰
     * 静态变量被所有对象公用，不需要实例化对象就可使用
     * 静态变量可以用对象名访问，也可用类名访问，推荐用类名，不推荐用对象名
     * 类不能访问对象中成员变量
     */
    /*
     * 静态函数
     * 在函数名前加static
     * 静态函数可以用对象名访问，也可用类名访问，推荐用类名，不推荐用对象名
     * 错误：静态变函数所有对象公用，不需要实例化对象就可使用!!!
     * 实际上，zs和ls在底层上共有相同普通fun()函数！！！！
     * 只有一个框架，对象调用时自动附加对象名.函数名（）
     * 静态函数也是底层上只有一份，但静态函数不能访问普通成员变量，只能访问静态成员变量
     * 
     */
}

class customer {
    String account;
    static String bankname = "中华银行";

    void fun(String b) {
        account = b;
        System.out.println(account);
    }

    static void staticfun() {
        System.out.println(111);
    }

    // 所有对象公用内存的成员变量，将该变量定义为静态变量，加static修饰
    public static void main(String[] args) {
        customer zs = new customer();
        zs.fun("sss");// 自动附加zs.account
        customer ls = new customer();
        ls.fun("aaa");// 自动附lz.account
        zs.bankname = "中华银行";
        customer c = null;// 没对象，java没有指针
        // c.account=500;空指针异常,类似c++
        // 在实例化对象前就已为static分空间（在class编译时）
        customer.staticfun();
    }
}

/*
 * 练习
 * 1.对象实例化时给对像编号，从1开始
 */

class customer1 {
    String account;
    int id;
    static int count = 0;

    customer1() {
        count++;
        id = count;

    }

    public static void main(String[] args) {
        customer c1 = new customer();
        customer c2 = new customer();
        /* ... */
        customer c4 = new customer();
    }
}

/*
 * 2.QQ：登录界面有账号，登陆成功后账号要传给好友列表界面
 * 100个界面定义100个account 重复使用，故需static,方便在不同对象间传递
 * 不断传递信息
 */
class user {
    static String account;
}

class login {
    String password;

    void login() {
        // 登录框输入账号到user
        System.out.println("account,password");
        list list = new list();
        // list界面显示
    }
}

class list {

    // 据login,account 载入信息
    public static void main(String[] args) {

    }
}

/*
 * 3.很多操作要求：内存中对象个数不超过1个
 * eg.只打开一个内存管理器
 */
class desktop {
    taskmanager tm = new taskmanager();// 在类初始化时会预加载，若很多的话会很耗时

    void click() {
        /* taskmanager tm = new taskmanager();//会造成多次实例化 */
        tm.show();
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
    taskmanager() {
        System.out.println("taskmanager实例化");
    }

    void show() {
        System.out.println("taskmanager 显示");
    }
}