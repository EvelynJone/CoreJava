package com.corejava.TDateMaintainUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name : Test<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2117:18<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Test {
    public static void main(String[] args) {
        HolidayDesc desc = new HolidayDesc("s","1");
        HolidayDesc desc2 = new HolidayDesc("s","1");
        System.out.println(desc.equals(desc2));
        System.out.println(desc.hashCode() +"  "+ desc2.hashCode());
        List<HolidayDesc> list = new ArrayList<>();
        list.add(desc);
        Iterator<HolidayDesc> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        for (HolidayDesc holidayDesc : list) {
            list.get(0);
        }
        Set<HolidayDesc> set = new HashSet<>();
        set.add(desc);
        set.add(desc2);
        System.out.println(set.size());
        String json = "{a},{b},{c},{d}{d}";
        Pattern holidayData = Pattern.compile("\\{(.*?)\\},?");
        Matcher holidayDataMather = holidayData.matcher(json);
        while (holidayDataMather.find()){
            System.out.println("{"+ holidayDataMather.group(1)+"}");
        }
    }
}