package com.corejava.TDateMaintainUtil;

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
        String json = "{a},{b},{c},{d}{d}";
        Pattern holidayData = Pattern.compile("\\{(.*?)\\},?");
        Matcher holidayDataMather = holidayData.matcher(json);
        while (holidayDataMather.find()){
            System.out.println("{"+ holidayDataMather.group(1)+"}");
        }
    }
}
