package com.corejava.ch5;

import sun.swing.plaf.windows.ClassicSortArrowIcon;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Class Name : ReflectionTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1910:00<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name ;
        if (args.length > 0) {
            name = args[0];
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a class name :");
            name = scanner.next();
        }

        try {
            Class clazz = Class.forName(name);
            Class superCl = clazz.getSuperclass();

            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0)
                System.out.println(modifiers + " ");
            System.out.println("class " + name);
            if (superCl != null && superCl != Object.class)
                System.out.println(" extends " + superCl.getName());
            System.out.println("\n{\n");
            printConstructors(clazz);
            System.out.println();
            printMethods(clazz);
            System.out.println();
            printFields(clazz);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifier = Modifier.toString(c.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0 ; j < paramTypes.length ; j ++) {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] parameters = m.getParameterTypes();
            for (int j = 0 ; j < parameters.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(parameters[j].getName());
            }
            System.out.println(");");
        }
    }
    public static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name+";");
        }
    }
}
