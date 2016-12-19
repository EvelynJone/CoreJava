package com.corejava.ch5;

import com.corejava.ch4.Manage;

/**
 * Class Name : Manager<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1514:35<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Manager other = (Manager) obj;
        return bonus == other.bonus;
    }
}
