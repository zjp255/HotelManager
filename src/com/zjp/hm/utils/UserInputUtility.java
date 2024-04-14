package com.zjp.hm.utils;

import java.util.Scanner;

/**
 * @author ZhuJinPeng
 * @version 1.0
 * 获得用户在控制台的输入
 */
public class UserInputUtility {
    private static Scanner scanner = new Scanner(System.in);
    public static String getInputKey(int count)
    {
        String next = "";
        while(true) {
            next = scanner.nextLine();
            if (next.length() > count) {
                System.out.println("输入的字符数大于" + count + ",请重新输入：");
            }else {
                break;
            }
        }
        return next;
    }
    public static boolean getYN()
    {
        String inputKey = getInputKey(1);
        if(inputKey.equals("y") || inputKey.equals("Y"))
        {
            return true;
        }else if(inputKey.equals("n") || inputKey.equals("N"))
        {
            return false;
        }
        else {
            System.out.println("输入错误请重新输入:");
            return getYN();
        }
    }
}
