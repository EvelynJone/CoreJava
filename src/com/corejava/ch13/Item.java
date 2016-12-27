package com.corejava.ch13;

import java.util.Objects;

/**
 * Class Name : Item<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2616:58<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public Item() {
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;
    }

    @Override
    public String toString() {
        return "[description=" +description + ",partNumber=" + partNumber + "]";
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber,o.partNumber);
    }
}
