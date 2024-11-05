package 实例化对象及传值传地址;

public class second_class {
    public static void main(String[] args) {
        // 通过类实例化对象
        customer zhang = new customer();
        customer liCustomer = new customer();
        zhang.balance = 1000;
        liCustomer.balance = 11111;

        zhang.welcome();
        // customer[] a = new customer[100];没有实例化，会报错
        customer[] a = new customer[100];
        for (int i = 1; i < 100; i++) {
            // 实例化a
            a[i] = new customer();
            a[i].balance = i;
        }
    }
}

class customer {
    String account;
    String password, cname;
    double balance;

    void welcome() {
        System.out.println("welcome");
    }

    void deposit(double dollar) {
        balance += dollar;
        System.out.println(dollar);
    }

    boolean qukuan(double money) {
        if (balance < money) {
            System.out.println("存款不够");
            return false;
        } else {
            balance -= money;
            System.out.println("取款" + money + "成功");
            return true;
        }

    }

    // 先判断小概率不成功的例子，再对大概率成功的功能操作
    /*
     * 好处：
     * 1. 提高代码可读性和可维护性
     * 通过先处理异常或错误情况，代码逻辑变得更加清晰。开发者可以一眼看到代码是如何处理错误的，然后再关注正常的业务逻辑。这种结构使代码更易于理解和维护。
     * 
     * 2. 提高代码效率
     * 在大多数情况下，程序会执行大概率成功的操作。通过先处理小概率不成功的情况，可以尽早退出方法，避免执行不必要的代码，从而提高程序的效率。
     * 
     * 3. 减少嵌套层次
     * 通过先处理错误情况，可以使用 return 语句尽早退出方法，减少代码的嵌套层次，使代码更加简洁和易读。
     * 
     * 4. 提高鲁棒性
     * 先处理异常情况可以确保在执行主要逻辑之前，所有潜在的问题都已经被处理。这种方式可以提高程序的鲁棒性，减少意外错误的发生。
     * 
     * 
     */
    void zhuanzhang(customer a, double money) {

        if (!qukuan(money)) {
            System.out.println("取款失败");
            return;
        } else
            qukuan(money);
        a.deposit(money);
        System.out.println("转账成功");
    }

    // 一切类型均使用值传递,将zhang的地址复制给a,实际张的地址没变
    // 若是对其中的内存中操作，则可以改变
    void swap(customer a, customer b) {
        customer c;
        c = a;
        a = b;
        b = c;
    }

}
