package com.corejava.ch5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Class Name : CopyTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1912:27<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class CopyTest {
    public static void main(String[] args) {


        String[] b = {"Tom","Dick","Harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));
        Integer[] a = {1,2,3};
        a = (Integer[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));
        System.out.println("The following call will generate an exception.");
        Integer[] in = new Integer[]{1,2,3};
        System.out.println(Arrays.toString(badCopy(in,10)));
        in = (Integer[]) badCopy(in,10);
//        System.out.println(Arrays.toString(ins));
    }

    private static Object[] badCopy(Object[] a, int newLength) {
 /*       这段代码是可以强转成功的。
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        Object[] newa = (Object[]) Array.newInstance(componentType,newLength);*/
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }

    private static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
//        Class componentType = cl.getClass();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
