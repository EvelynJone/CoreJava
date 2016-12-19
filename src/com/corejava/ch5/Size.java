package com.corejava.ch5;

/**
 * Class Name : Size<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1617:19<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public enum  Size {
    SMALL("s"),
    MEDIUM("m"),
    LAGER("l"),
    EXTRA_LAGER("xl");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
