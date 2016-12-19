package com.corejava.ch5;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class Name : Employee<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1514:18<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Employee extends Person implements Comparable<Employee>,Cloneable{
    private double salary;
    private Date hireDay;

    public Employee() {
    }

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public String getDescrip() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;

        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return getName().equals(other.getName()) && salary == other.salary && hireDay.equals(other.getHireDay());
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary,other.salary);
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return getClass().getName() + "["
                +"name="+getName()
                +",salary="+salary
                +",hireDay="+hireDay;
    }
}
