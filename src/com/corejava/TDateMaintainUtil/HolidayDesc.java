package com.corejava.TDateMaintainUtil;

import java.io.Serializable;
import java.util.Objects;

public class HolidayDesc implements Serializable {
    private String date;
    private String status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        HolidayDesc other = (HolidayDesc) obj;
        return Objects.equals(date,other.date) && Objects.equals(status,other.status);
    }

    public int hashCode() {
        return Objects.hash(date,status);
    }
}