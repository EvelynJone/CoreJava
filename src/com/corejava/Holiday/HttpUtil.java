//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.corejava.Holiday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static String sendHttp(String url,String readerEncoding) throws Exception {
        StringBuffer retu = new StringBuffer("");
        URL httpUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
//        con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
        con.setRequestProperty("Content-Type","application/json");
        OutputStream os = con.getOutputStream();
//        os.write(xmlStr.getBytes());
        os.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), readerEncoding));

        String line;
        while((line = reader.readLine()) != null) {
            retu.append(line);
        }

        os.close();
        reader.close();
        con.disconnect();
        return retu.toString();
    }
}
