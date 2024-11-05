package JAVA应用开发.异常处理;

/* 异常处理
在 Java 中使用 Scanner 类的 nextInt() 方法读入用户输入时，如果输入的不是整数，程序会抛出 InputMismatchException。要处理这种异常，可以使用 try-catch 结构来捕获异常并在 catch 中进行相应的处理。
以下是一个示例，展示如何处理用户输入不是整数的情况： */

import java.util.Scanner;
import java.util.InputMismatchException;

 class m {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0; // 用于存储正确的整数
        boolean validInput = false; // 用于标识是否获得有效输入

        // 使用循环不断要求输入，直到获得有效的整数
        while (!validInput) {
            System.out.print("请输入一个整数: ");
            try {
                number = scanner.nextInt(); // 尝试读取整数
                validInput = true; // 如果成功读取整数，则将标识设为 true
            } catch (InputMismatchException e) {
                // 如果捕获到 InputMismatchException 异常
                System.out.println("输入无效，请输入一个整数。");
                scanner.next(); // 清除当前的错误输入，防止无限循环
            }
        }

        System.out.println("您输入的整数是: " + number);
    }

}

/*
 * 解释：
 * 1. try 块:
 * 使用 nextInt() 尝试读取用户输入的整数。
 * 2. catch 块: 捕获 InputMismatchException，并提示用户输入无效，同时通过 scanner.next()
 * 清除错误输入，以防止无限循环。
 * 3. 循环控制: 使用 while 循环确保程序不断要求输入，直到用户输入有效的整数为止。
 * 
 * 这样做可以确保程序在遇到非整数输入时不会崩溃，并可以继续提示用户直到获得正确的输入。
 */
public class eighth_class {
    public static void main(String[] args) {
    }
}
