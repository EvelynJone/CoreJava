package com.corejava.TDateMaintainUtil;
import java.io.Serializable;

public class BaiduData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Holiday holiday;

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}