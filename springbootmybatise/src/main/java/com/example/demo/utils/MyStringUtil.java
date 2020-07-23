package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtil {
    // 去掉空格、换行符、制表符
    /**
     * 去除字符串中的空格、回车、换行符、制表符等
     * @param str
     * @return
     */
    public static String replaceSpecialStr(String str) {
        if(str == null) {
            throw new NullPointerException("参数为空!");
        }
        String repl;
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        repl = m.replaceAll("");
        return repl;
    }

    public static void main(String[] args) {
//        String test = "hello " +
//                "world";
//        System.out.println(test);
//        String test2 = "hello world";
//        System.out.println(test.equals(test2));
        //System.out.println(replaceSpecialStr(test));
    }
}
