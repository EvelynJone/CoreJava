package com.corejava.ch3;

/**
 * Class Name : Constants<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1313:36<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Constants {
    // 类常量(类中所有方法都可以使用这个常量，当类常量修饰为public的时候，其他类也可以使用这个常量，使用方法为Constants.THE_STATIC_FINAL_STRING)
    public static final String THE_STATIC_FINAL_STRING = "the static final string";
    public static void main(String[] args) {
        // 常量
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters : " + paperWidth*CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
//        CM_PER_INCH = 9;  被final修饰的变量就是常量，赋值之后不能再进行修改。
        System.out.println(THE_STATIC_FINAL_STRING);
        String s = "ni,ha,o";
        System.out.println(changeToVarchar(s));
    }

    public static String changeToVarchar(String some) {
        StringBuffer result = new StringBuffer();
        String[] somes = some.split(",");
        for (String temp : somes) {
            result.append("'" + temp + "',");
        }
        return result.substring(0,result.length() - 1).toString();
    }
}

class TestConstans{
    public static void main(String[] args) {
        System.out.println(Constants.THE_STATIC_FINAL_STRING);
    }
}
