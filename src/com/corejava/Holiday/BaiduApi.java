package com.corejava.Holiday;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Name : BaiduApi<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2010:29<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class BaiduApi {
    private List<Holiday> holiday = new ArrayList<>();

    public List<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(List<Holiday> holiday) {
        this.holiday = holiday;
    }
}
