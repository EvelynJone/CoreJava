package com.corejava.TDateMaintainUtil;

import java.io.Serializable;
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
public class BaiduApi implements Serializable{

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private List<BaiduData> data;

    public List<BaiduData> getData() {
        return data;
    }

    public void setData(List<BaiduData> data) {
        this.data = data;
    }
}




