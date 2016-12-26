package com.corejava.ch12;

/**
 * Class Name : PairTest1<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2310:10<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        Pair<String> mm = new ArrayAlg().minmax(words);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());
    }
}

class ArrayAlg{
    public static Pair<String> minmax(String [] a ) {
        if (null == a && a.length == 0 )
            return null;
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length ; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    /**
     * 泛型方法：类型变量放在修饰符后面，返回类型的前面，就是 <T>
     * 使用方法：String middle = ArrayAlg.<String>getMiddle("Jone","M","Pun");
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddel(T... a) {
        return a[a.length / 2];
    }

    /**
     * 类型变量的限定
     *  比如<T extends Comparable>就要求T必须是继承了Comparable接口的类才可以
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T min(T[] a) {
        if (null == a && a.length == 0) return  null;
        T smallest = a[0];
        for (int i = 0 ; i < a.length; i ++){
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        }
        return smallest;
    }
}
