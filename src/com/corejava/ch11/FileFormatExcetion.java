package com.corejava.ch11;

import java.io.IOException;

/**
 * Class Name : FileFormatExcetion<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2213:40<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class FileFormatExcetion extends IOException {
    public FileFormatExcetion() {
    }

    public FileFormatExcetion(String gripe) {
        super(gripe);
    }
}
