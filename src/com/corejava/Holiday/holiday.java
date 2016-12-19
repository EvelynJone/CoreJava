package com.corejava.Holiday;


	import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.util.Date;



public class holiday {

    /**

     * @param

     *            :请求接口

     * @param httpArg

     *            :参数

     * @return 返回结果

     */

    public static String request( String httpArg) {

        String httpUrl="http://apis.baidu.com/xiaogg/holiday/holiday";

        BufferedReader reader = null;

        String result = null;

        StringBuffer sbf = new StringBuffer();

        httpUrl = httpUrl + "?" + httpArg;



        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url

                    .openConnection();

            connection.setRequestMethod("GET");

            // 填入apikey到HTTP header

            connection.setRequestProperty("apikey",  "7bd4e99adcc28e337cea79191fef87fc");

            connection.connect();

            InputStream is = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {

                sbf.append(strRead);

                sbf.append("\r\n");

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }



    public static void main(String[] args) {

        //判断今天是否是工作日 周末 还是节假日
		Date fitst = new Date(2017,1,1);
		Date end = new Date(2017,12,31);
		for (Date date = fitst; end.after(fitst);) {
			String httpArg="d="+date;

			String jsonResult = request(httpArg);

			System.out.println(jsonResult);
		}


    }



}