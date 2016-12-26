package com.corejava.ch6;

/**
 * Class Name : StaticInnerClassTest<BR>
 * Descripe : 静态内部类
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2115:47<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[2];
        for (int i = 0 ; i < d.length ;  i ++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min= " + p.getFirst());
        System.out.println("max= " + p.getSecond());
    }
}

class ArrayAlg {
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    // 如果Pair类没有声明为static，那么这个方法不能以static的形式返回
    public static Pair minmax(double[] values) {
        double min = values[0];
        double max = values[1];
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min,max);
    }
}
