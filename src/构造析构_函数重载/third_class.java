package 构造析构_函数重载;
public class third_class {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        customer zs = new customer("qqqq", "aa");
        // 此处有5000行代码
        // 张三再初始化为张三0

        zs = null;
        System.gc(); // 强制马上垃圾收集
    }
}

class customer {
    String account;
    String password, cname;
    double balance;

    /*
     * 构造函数（构造子）
     * 是一种成员函数，对对象进行初始化
     * 一般初始化在main函数中，为了简化代码格式，在类中进行初始化，即构造函数
     * 名称和类名相同，无返回类型
     * 对象new时自动调用
     * 不可手动调用，在对象生命周期中不可再次调用
     */
    customer(String account, String cname) {
        // 构造函数（构造子）
        this.account = account;
        this.cname = cname;
        // this.用来标记某个成员是类中成员，不是局部成员
    }

}

/*
 * 练习：构造函数在生命周期中只自动调用一次，若之后还需要初始化怎么做，恢复默认值
 * 如果类中没有构造函数，系统生成默认构造函数
 */
class customer1 {
    String account;
    String password, cname;
    double balance;

    customer1(String account, String cname) {
        init(account, cname);
    }

    void init(String account, String cname) {
        this.account = account;
        this.cname = cname;
    }
}

class customer2 {
    String account;

    // 析构函数：对象消亡自动完成的工作
    // java中不需析构函数，用finalize函数代替
    // 自动收集，在若干小时后
    public void finalize() {
        System.out.println("清理对象内存空间");
    }

    /*
     * 函数重载overload
     * 类里能否定义多个同名函数
     * 可以，满足以下三个条件即可
     * 参数个数不同；参数个数相同，类型不同；参数个数，类型相同，出现顺序不同
     * 只用返回类型不同不行
     * 重载的作用？
     * 一个函数名在不同情况下完成对应不同功能：【静态多态性】
     * 通过不同实参类型和个数，系统自动定位到对应函数，开发者少用函数名，使用者也不用记
     */
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

// 练习，编写复数类，实现复数加法
// a+bi
class fushu {
    int a, b;

    fushu(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void print() {

        System.out.println(a + b + "i");
    }

    fushu add(fushu c1) {

        return new fushu(c1.a + this.a, this.b + c1.b);
    }

    // 支持连加：c1.add(c2).add(c3).add(c4)
    // 仍有问题：造成大量内存浪费，new了很多
    fushu addnew(fushu customer1) {
        this.a += customer1.a;
        this.b += customer1.b;
        return this;
    }
}
// 代价：c1被牺牲c5=c1.add(c2).add(c3).add(c4)
// 解决：使用c0，先初始化一个c0,再对c0进行操作
