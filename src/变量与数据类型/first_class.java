package 变量与数据类型;
public class first_class {
    public static void main(String[] args) {
        System.out.print("hello" + "word");
        System.out.println("src");
        // 变量和数据类型：
        byte b = 12;
        int v = 12;
        short s = 12;
        long e = 12344555L;// long定义后面加L

        s = b;
        // b=s;高精度不能转换为低精度
        b = (byte) s;// 强制类型转换
        System.out.println(b);

        double f = 3.13333d;// 默认为double，故需加d
        double q = 3.1111111111;

        char ch = 'a';
        int cha = ch;
        System.out.println(cha);

        for (int i = 0; i < 128; i++) {
            System.out.println((char) i + " ");
            System.out.println((char) '中' + i);
        }

        /* 转义字符 打印笑脸 前加\ */
        System.out.println("^_^");

        /* bool型 */
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(3 > 5);
        /* c语言定义数组a,从a开始开辟10个int空间，由a[0]到a[9]访问 */
        int a[] = new int[10];
        /* Java写法：开辟10给地址空间，赋值首地址给定义的数组a */
        int[] b3 = new int[10];
        /* 用法 */
        // 初始化
        int[] c = new int[] { 1, 2 };
        int[] c2 = new int[] { 1, 2, 3 };
        c = c2;// 类似于指针，可以直接做左值，但是会造成内存泄漏，c2指向的内存泄漏

        int[][] a1 = new int[][] { { 1, 2 }, { 2, 4, 5, 6 } };
        /* 二维数组可以先定义行数，每列之后再定义，不需对齐 */
        int[][] a2 = new int[3][];
        a2 = new int[][] { { 1, 2, 3 }, { 1, 2, 3, 4 }, { 1 } };

        /*
         * // 求根号2
         * double w = 2;
         * double low = 0, high = w;
         * double mid = (low + high) / 2;
         * for (int i = 0; i < 100; i++) {
         * mid = (low + high) / 2;
         * if (mid * mid > w)
         * low = mid;
         * else
         * high = mid;
         * }
         * System.out.println(mid);
         */
        /*
         * // 求末年末月的天数，概率较大的if语句写在前面
         * int y = 2024;
         * int m = 5;
         * if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
         * System.out.println("31天");
         * } else if (m == 4 || m == 6 || m == 9 || m == 11) {
         * System.out.println("30天");
         * } else if (m == 2) {
         * if (y % 4 == 0 && y % 100 == 0 || y % 400 == 0)
         * System.out.println("28");
         * else {
         * System.out.println("29");
         * }
         * }
         */

        // Math.random()产生一个0-1之间随机数double[0-1)
        // 产生一个0-1之间的随机数，>=0.5赢否则输，玩家一万元，赢一次1000元，输一次1000元，玩一百次，输光退出，看多少次能坚持玩到100次并且赢钱

        int wincount = 100;
        boolean ifwin = false;
        int fund = 10000;
        for (int i = 0; i < wincount; i++) {
            double rand = Math.random();
            if (rand >= 0.5) {
                fund += 1000;
            } else {
                fund -= 1000;
            }
            if (fund <= 0) {
                System.out.println("输了");
                break;
            }

        }
        if (fund > 10000) {
            System.out.println("win");
        }

    }
}
