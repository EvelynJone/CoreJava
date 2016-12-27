package com.corejava.ch13;

import com.corejava.ch4.Manage;
import com.corejava.ch5.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class Name : MapTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2713:48<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class MapTest {
    public static void main(String[] args) {
        //Map<String,Employee> staff = new HashMap<>();
        // 连接映射表
        Employee employee = new Employee("Gary Cooper");
        Map<String,Employee> staff = new LinkedHashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",employee);
        staff.put("456-62-5527",new Employee("Francesca Cruz"));

        Iterator<String> keys = staff.keySet().iterator();
        while (keys.hasNext()) {
            System.out.println(keys.next());
        }
        Iterator<Employee> values = staff.values().iterator();
        while (values.hasNext()) {
            System.out.println(values.next());
        }

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5527",new Employee("Francesca Miller"));
        staff.put("ceshi",employee);
        System.out.println(staff.get("157-62-7935"));

        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key=" + key + " , value = " + value);
        }

    }
}
