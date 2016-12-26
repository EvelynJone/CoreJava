package com.corejava.ch12;

/**
 * Class Name : Block<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2314:16<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public abstract class Block {
    public abstract  void body() throws Exception;

    public Thread toThread() {
        return new Thread() {
          public void run(){
                try {
                    body();
                }catch (Throwable t) {
                    Block.<RuntimeException>throwAs(t);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable t) throws T {
        throw (T)t;
    }
}
