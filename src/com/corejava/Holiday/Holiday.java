package com.corejava.Holiday;

import java.util.List;

/**
 * Class Name : Holiday<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2010:30<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Holiday {

    private String name;
    private String festival;
    private String desc;
    private List<HolidayDesc> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<HolidayDesc> getList() {
        return list;
    }

    public void setList(List<HolidayDesc> list) {
        this.list = list;
    }
}
