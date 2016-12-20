package com.corejava.TDateMaintainUtil;

import java.io.Serializable;
import java.util.List;

class Holiday implements Serializable {

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