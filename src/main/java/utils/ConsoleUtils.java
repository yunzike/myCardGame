package utils;

import java.util.Scanner;

/**
 * @author xiongxq
 * @Description ConsoleUtil
 * @date 2020/9/18 11:47 下午
 * version: 1.0
 */
public class ConsoleUtils {

    public static void showText(boolean hasStar, boolean lineBreak, String... contents) {
        System.out.print(hasStar ? "\n*******************************\n" : "");
        if (contents.length == 1) {
            System.out.print(contents[0]);

            System.out.print(hasStar ? "\n" : "");
        } else {
            for (int i = 0; i < contents.length; i++) {
                System.out.println((i + 1) + "." + contents[i]);
            }
        }
        System.out.print(hasStar ? "*******************************\n" : "");
        System.out.print(lineBreak ? "\n" : "");
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
