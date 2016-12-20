package com.corejava.httpUtil;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpUtil {
  static HostnameVerifier hv = new HostnameVerifier() {
    public boolean verify(String urlHostName, SSLSession session) {
      System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
      return true;
    }
  };

  public HttpUtil() {
  }

  public static String sendHttps_(String httpsUrl, String xmlStr, String encoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    HttpsURLConnection urlCon = null;
    trustAllHttpsCertificates_();
    urlCon = (HttpsURLConnection)(new URL(httpsUrl)).openConnection();
    urlCon.setDoInput(true);
    urlCon.setDoOutput(true);
    urlCon.setRequestMethod("POST");
    urlCon.setUseCaches(false);
    if(null != encoding) {
      urlCon.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes(encoding).length));
      urlCon.getOutputStream().write(xmlStr.getBytes(encoding));
    } else {
      urlCon.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
      urlCon.getOutputStream().write(xmlStr.getBytes());
    }

    urlCon.getOutputStream().flush();
    urlCon.getOutputStream().close();
    BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

    String line;
    while((line = in.readLine()) != null) {
      retu.append(line);
    }

    return retu.toString();
  }

  public static String sendHttps(String httpsUrl, String xmlStr, String readerEncoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    HttpsURLConnection urlCon = null;
    trustAllHttpsCertificates_();
    urlCon = (HttpsURLConnection)(new URL(httpsUrl)).openConnection();
    urlCon.setDoInput(true);
    urlCon.setDoOutput(true);
    urlCon.setRequestMethod("POST");
    urlCon.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
    urlCon.setUseCaches(false);
    urlCon.getOutputStream().write(xmlStr.getBytes());
    urlCon.getOutputStream().flush();
    urlCon.getOutputStream().close();
    BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), readerEncoding));

    String line;
    while((line = in.readLine()) != null) {
      retu.append(line);
    }

    return retu.toString();
  }

  public static String sendHttps(String httpsUrl, String xmlStr) throws Exception {
    return sendHttps_(httpsUrl, xmlStr, (String)null);
  }

  public static String sendHttps(String httpsUrl, String xmlStr, String sendEncoding, String readEncoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    HttpsURLConnection urlCon = null;
    trustAllHttpsCertificates_();
    urlCon = (HttpsURLConnection)(new URL(httpsUrl)).openConnection();
    urlCon.setDoInput(true);
    urlCon.setDoOutput(true);
    urlCon.setRequestMethod("POST");
    urlCon.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes(sendEncoding).length));
    urlCon.setUseCaches(false);
    urlCon.getOutputStream().write(xmlStr.getBytes(sendEncoding));
    urlCon.getOutputStream().flush();
    urlCon.getOutputStream().close();
    BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), readEncoding));

    String line;
    while((line = in.readLine()) != null) {
      retu.append(line);
    }

    return retu.toString();
  }

  public static String sendHttp(String url, String xmlStr) throws Exception {
    return sendHttp_(url, xmlStr, (String)null);
  }

  public static String sendHttp_(String url, String xmlStr, String encoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    URL httpUrl = new URL(url);
    HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setUseCaches(false);
    OutputStream os = con.getOutputStream();
    if(null != encoding) {
      con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes(encoding).length));
      os.write(xmlStr.getBytes(encoding));
    } else {
      con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
      os.write(xmlStr.getBytes());
    }

    os.flush();
    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

    String line;
    while((line = reader.readLine()) != null) {
      retu.append(line);
    }

    os.close();
    reader.close();
    con.disconnect();
    return retu.toString();
  }

  public static String sendHttp(String url, String xmlStr, String readerEncoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    URL httpUrl = new URL(url);
    HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setUseCaches(false);
    con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
    OutputStream os = con.getOutputStream();
    os.write(xmlStr.getBytes());
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

  public static String sendHttp(String url, String xmlStr, String sendEncoding, String readEncoding) throws Exception {
    StringBuffer retu = new StringBuffer("");
    URL httpUrl = new URL(url);
    HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setUseCaches(false);
    con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes(sendEncoding).length));
    OutputStream os = con.getOutputStream();
    os.write(xmlStr.getBytes(sendEncoding));
    os.flush();
    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), readEncoding));

    String line;
    while((line = reader.readLine()) != null) {
      retu.append(line);
    }

    os.close();
    reader.close();
    con.disconnect();
    return retu.toString();
  }

  public static String sendHttpsUrl(String requestUrl, String requestMethod, String outputStr, String encoding) {
    String retu = null;
    StringBuffer buffer = new StringBuffer();

    try {
      TrustManager[] e = new TrustManager[]{new MyX509TrustManager()};
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init((KeyManager[])null, e, new SecureRandom());
      SSLSocketFactory ssf = sslContext.getSocketFactory();
      URL url = new URL(requestUrl);
      HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
      httpUrlConn.setSSLSocketFactory(ssf);
      httpUrlConn.setDoOutput(true);
      httpUrlConn.setDoInput(true);
      httpUrlConn.setUseCaches(false);
      httpUrlConn.setRequestMethod(requestMethod);
      if("GET".equalsIgnoreCase(requestMethod)) {
        httpUrlConn.connect();
      }

      OutputStream inputStream;
      if(null != outputStr) {
        inputStream = httpUrlConn.getOutputStream();
        inputStream.write(outputStr.getBytes(encoding));
        inputStream.close();
      }

      InputStream inputStream1 = httpUrlConn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream1, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;

      while((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }

      bufferedReader.close();
      inputStreamReader.close();
      inputStream1.close();
      inputStream = null;
      httpUrlConn.disconnect();
      retu = buffer.toString();
    } catch (ConnectException var15) {
      var15.printStackTrace();
    } catch (Exception var16) {
      var16.printStackTrace();
    }

    return retu;
  }

  public static String sendHttpsUrl(String requestUrl, String requestMethod, String outputStr) {
    return sendHttpsUrl(requestUrl, requestMethod, outputStr, "utf-8");
  }

  public static String sendHttpStream(String url, String filePathName) throws Exception {
    StringBuffer retu = new StringBuffer("");
    URL httpUrl = new URL(url);
    HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
    con.setRequestMethod("POST");
    con.setDoOutput(true);
    con.setDoInput(true);
    con.setUseCaches(false);
    OutputStream outputStream = con.getOutputStream();
    StringBuilder sb = new StringBuilder();
    String BOUNDARY = "---------7d4a6d158c9";
    byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
    sb.append("--");
    sb.append(BOUNDARY);
    sb.append("\r\n");
    String fileName = filePathName.substring(filePathName.lastIndexOf("/"));
    sb.append("Content-Disposition: form-data;name=\"file1\";filename=\"" + fileName + "\"\r\n");
    sb.append("Content-Type:application/octet-stream\r\n\r\n");
    sb.append(end_data);
    byte[] data = sb.toString().getBytes();
    outputStream.write(data);
    FileInputStream fis = new FileInputStream(filePathName);
    byte[] outBuff = new byte[1024];

    int outSize;
    while((outSize = fis.read(outBuff, 0, 1024)) > 0) {
      outputStream.write(outBuff, 0, outSize);
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

    String line;
    while((line = reader.readLine()) != null) {
      retu.append(line);
    }

    outputStream.flush();
    outputStream.close();
    fis.close();
    return retu.toString();
  }

  public static String sendFile(String url, String filePath) throws IOException {
    String result = null;
    File file = new File(filePath);
    if(file.exists() && file.isFile()) {
      URL urlObj = new URL(url);
      HttpURLConnection con = (HttpURLConnection)urlObj.openConnection();
      con.setRequestMethod("POST");
      con.setDoInput(true);
      con.setDoOutput(true);
      con.setUseCaches(false);
      con.setRequestProperty("Connection", "Keep-Alive");
      con.setRequestProperty("Charset", "UTF-8");
      String BOUNDARY = "----------" + System.currentTimeMillis();
      con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
      StringBuilder sb = new StringBuilder();
      sb.append("--");
      sb.append(BOUNDARY);
      sb.append("\r\n");
      sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
      sb.append("Content-Type:application/octet-stream\r\n\r\n");
      sb.append("Content-Type:application/octet-stream\r\n\r\n");
      byte[] head = sb.toString().getBytes("utf-8");
      DataOutputStream out = new DataOutputStream(con.getOutputStream());
      out.write(head);
      DataInputStream in = new DataInputStream(new FileInputStream(file));
      boolean bytes = false;
      byte[] bufferOut = new byte[1024];

      int bytes1;
      while((bytes1 = in.read(bufferOut)) != -1) {
        out.write(bufferOut, 0, bytes1);
      }

      in.close();
      byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");
      out.write(foot);
      out.flush();
      out.close();
      StringBuffer buffer = new StringBuffer();
      BufferedReader reader = null;

      try {
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String e = null;

        while((e = reader.readLine()) != null) {
          buffer.append(e);
        }

        if(result == null) {
          result = buffer.toString();
        }
      } catch (IOException var20) {
        System.out.println("发送POST请求出现异常！" + var20);
        var20.printStackTrace();
        throw new IOException("数据读取异常");
      } finally {
        if(reader != null) {
          reader.close();
        }

      }

      return result;
    } else {
      throw new IOException("文件不存在");
    }
  }

  public static String loadHtmlBodyByGet(String url) {
    return loadHtmlBody(url, (Map)null, false);
  }

  public static String loadHtmlBodyByPost(String url) {
    return loadHtmlBody(url, (Map)null, true);
  }

  public static void setProxy(String proxyIp, String proxyPort) {
    System.getProperties().setProperty("http.proxyHost", proxyIp);
    System.getProperties().setProperty("http.proxyPort", proxyPort);
  }

  public static String loadHtmlBody(String url, Map<String, String> paras, boolean isPost) {
    String ret = "";

    try {
      Connection e = Jsoup.connect(url);
      if(null != paras) {
        e.data(paras);
      }

      Document doc = isPost?e.post():e.get();
      ret = doc.body().toString();
    } catch (IOException var6) {
      var6.printStackTrace();
    }

    return ret;
  }

  public static String loadHtmlBodyElementById(String url, Map<String, String> paras, String id, boolean isPost, Map<String, String> header) {
    String ret = "";

    try {
      Connection e = Jsoup.connect(url);
      setHeader(e, header);
      if(null != paras) {
        e.data(paras);
      }

      Document doc = isPost?e.post():e.get();
      Element e1 = doc.getElementById(id);
      ret = e1.html();
    } catch (IOException var9) {
      var9.printStackTrace();
    }

    return ret;
  }

  public static String loadHtmlBodyElementById(String url, Map<String, String> paras, String id, boolean isPost) {
    return loadHtmlBodyElementById(url, paras, id, isPost);
  }

  public static String loadHtmlBodyElementById(String url, String id, boolean isPost, Map<String, String> header) {
    return loadHtmlBodyElementById(url, (Map)null, id, isPost, header);
  }

  public static String loadHtmlBodyElementById(String url, String id, boolean isPost) {
    return loadHtmlBodyElementById(url, (Map)null, id, isPost, (Map)null);
  }

  public static String loadHtmlBodyElementsByClass(String url, Map<String, String> paras, String className, boolean isPost, Map<String, String> header) {
    String ret = "";

    try {
      Connection e = Jsoup.connect(url);
      setHeader(e, header);
      if(null != paras) {
        e.data(paras);
      }

      Document doc = isPost?e.post():e.get();
      Elements es = doc.getElementsByClass(className);

      Element e1;
      for(Iterator i$ = es.iterator(); i$.hasNext(); ret = ret + e1.html()) {
        e1 = (Element)i$.next();
      }
    } catch (IOException var11) {
      var11.printStackTrace();
    }

    return ret;
  }

  public static String loadHtmlBodyElementsByClass(String url, Map<String, String> paras, String className, boolean isPost) {
    return loadHtmlBodyElementsByClass(url, paras, className, isPost, (Map)null);
  }

  public static String loadHtmlBodyElementsByClass(String url, String className, boolean isPost, Map<String, String> header) {
    return loadHtmlBodyElementsByClass(url, (Map)null, className, isPost, header);
  }

  public static String loadHtmlBodyElementsByClass(String url, String className, boolean isPost) {
    return loadHtmlBodyElementsByClass(url, (Map)null, className, isPost, (Map)null);
  }

  public static String loadHtmlBodyElementsByTagName(String url, Map<String, String> paras, String tagName, boolean isPost, Map<String, String> header) {
    String ret = "";

    try {
      Connection e = Jsoup.connect(url);
      setHeader(e, header);
      if(null != paras) {
        e.data(paras);
      }

      Document doc = isPost?e.post():e.get();
      Elements es = doc.getElementsByTag(tagName);

      Element e1;
      for(Iterator i$ = es.iterator(); i$.hasNext(); ret = ret + e1.html()) {
        e1 = (Element)i$.next();
      }
    } catch (IOException var11) {
      var11.printStackTrace();
    }

    return ret;
  }

  public static String loadHtmlBodyElementsByTagName(String url, Map<String, String> paras, String tagName, boolean isPost) {
    return loadHtmlBodyElementsByTagName(url, paras, tagName, isPost, (Map)null);
  }

  public static String loadHtmlBodyElementsByTagName(String url, String tagName, boolean isPost, Map<String, String> header) {
    return loadHtmlBodyElementsByTagName(url, (Map)null, tagName, isPost, header);
  }

  public static String loadHtmlBodyElementsByTagName(String url, String tagName, boolean isPost) {
    return loadHtmlBodyElementsByTagName(url, (Map)null, tagName, isPost, (Map)null);
  }

  public static String loadHtmlBodyGetLinks(String url) {
    String retu = "";

    try {
      Document doc = Jsoup.connect(url).get();
      Elements e = doc.select("a[href]");

      Element link;
      for(Iterator i$ = e.iterator(); i$.hasNext(); retu = retu + link.outerHtml()) {
        link = (Element)i$.next();
      }
    } catch (IOException var6) {
      var6.printStackTrace();
    }

    return retu;
  }

  public static String getElementsContent(String url, String id, String executeJs) {
    String retu = "";
    WebClient webClient = new WebClient();
    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setCssEnabled(false);
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    webClient.getOptions().setTimeout(100000);
    webClient.getOptions().setThrowExceptionOnScriptError(true);
    webClient.getOptions().setDoNotTrackEnabled(false);

    try {
      HtmlPage page = (HtmlPage)webClient.getPage(url);
      if(null != executeJs) {
        page.executeJavaScript(executeJs).getJavaScriptResult();
      }

      if(null != id) {
        DomElement e = page.getElementById(id);
        retu = e.asXml();
      } else {
        retu = page.asXml();
      }
    } catch (Exception var7) {
      var7.printStackTrace();
    }

    webClient.closeAllWindows();
    return retu;
  }

  public static String getElementsContent(String url, String id) {
    return getElementsContent(url, id, (String)null);
  }

  public static String getHtmlContent(String url) {
    return getElementsContent(url, (String)null);
  }

  public static String getElementsContentByTagName(String url, String tagName, String executeJs) {
    String retu = "";
    WebClient webClient = new WebClient();
    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setCssEnabled(false);
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    webClient.getOptions().setTimeout(100000);
    webClient.getOptions().setThrowExceptionOnScriptError(true);
    webClient.getOptions().setDoNotTrackEnabled(false);

    try {
      HtmlPage page = (HtmlPage)webClient.getPage(url);
      if(null != executeJs) {
        page.executeJavaScript(executeJs).getJavaScriptResult();
      }

      if(null != tagName) {
        DomNodeList e = page.getElementsByTagName(tagName);

        DomElement e1;
        for(Iterator i$ = e.iterator(); i$.hasNext(); retu = retu + e1.asXml()) {
          e1 = (DomElement)i$.next();
        }
      } else {
        retu = page.asXml();
      }
    } catch (Exception var9) {
      var9.printStackTrace();
    }

    webClient.closeAllWindows();
    return retu;
  }

  public static String getElementsContentByTagName(String url, String tagName) {
    return getElementsContentByTagName(url, tagName, (String)null);
  }

  public static String getElementsContentByClassName(String url, String className, String executeJs) {
    String retu = "";
    String html = getElementsContent(url, (String)null, executeJs);
    Document doc = Jsoup.parse(html);
    Elements es = doc.getElementsByClass(className);

    Element e;
    for(Iterator i$ = es.iterator(); i$.hasNext(); retu = retu + e.html()) {
      e = (Element)i$.next();
    }

    return retu;
  }

  public static String getElementsContentByClassName(String url, String className) {
    return getElementsContentByClassName(url, className, (String)null);
  }

  public static Map<String, String> getHtmlLinks(String html, String perUrl, boolean filterEmpty) {
    HashMap map = new HashMap();
    Document doc = Jsoup.parse(html);
    Elements links = doc.select("a[href]");
    String per = null != perUrl?perUrl:"";
    Iterator i$ = links.iterator();

    while(i$.hasNext()) {
      Element link = (Element)i$.next();
      if(filterEmpty) {
        if(null != link.text() && !"".equals(link.text().trim())) {
          map.put(per + link.attr("href"), link.text());
        }
      } else {
        map.put(per + link.attr("href"), link.text());
      }
    }

    return map;
  }

  public static String getHtmlLinkStr(String html, String perUrl, boolean filterEmpty) {
    String retu = "";
    Document doc = Jsoup.parse(html);
    Elements links = doc.select("a[href]");
    String per = null != perUrl?perUrl:"";
    Iterator i$ = links.iterator();

    while(i$.hasNext()) {
      Element link = (Element)i$.next();
      if(filterEmpty) {
        if(null != link.text() && !"".equals(link.text().trim())) {
          retu = retu + per + link.attr("href") + ":" + link.text() + "\r\n";
        }
      } else {
        retu = retu + per + link.attr("href") + ":" + link.text() + "\r\n";
      }
    }

    return retu;
  }

  private static void trustAllHttpsCertificates() throws Exception {
    TrustManager[] trustAllCerts = new TrustManager[1];
    HttpUtil.miTM tm = new HttpUtil.miTM();
    trustAllCerts[0] = tm;
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init((KeyManager[])null, trustAllCerts, (SecureRandom)null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
  }

  private static void trustAllHttpsCertificates_() throws Exception {
    trustAllHttpsCertificates();
    HttpsURLConnection.setDefaultHostnameVerifier(hv);
  }

  private static void setHeader(Connection conn, Map<String, String> header) {
    if(null != header) {
      Iterator i$ = header.keySet().iterator();

      while(i$.hasNext()) {
        String key = (String)i$.next();
        conn.header(key, (String)header.get(key));
      }
    }

  }

  public static void main(String[] args) throws Exception {
    String u = "http://www.live.chinacourt.org/fygg/display/id/4276234.shtml";
    u = "http://www.live.chinacourt.org/fygg/ggsdsearch.shtml";
    String s = getElementsContentByTagName(u, "a", "$(\'#bltntype\').val(63);search(2);");
    System.out.println(s);
  }

  static class miTM implements TrustManager, X509TrustManager {
    miTM() {
    }

    public X509Certificate[] getAcceptedIssuers() {
      return null;
    }

    public boolean isServerTrusted(X509Certificate[] certs) {
      return true;
    }

    public boolean isClientTrusted(X509Certificate[] certs) {
      return true;
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
    }
  }
}
