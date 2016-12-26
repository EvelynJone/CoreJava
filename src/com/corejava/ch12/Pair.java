package com.corejava.ch12;

/**
 * Class Name : Pair<BR>
 * Descripe : 泛型
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/239:49<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
