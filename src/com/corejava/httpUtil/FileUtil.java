package com.corejava.httpUtil;

/*import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.trad.config.WebSiteConfig;
import com.trad.dao.file.FileNoticeRes;*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

    /**
     * 删除文件（如果是文件夹，连带删除目录下所有文件）
     * @param path 文件地址
     */
    public static void deleteAllFilesOfDir(File path) {
            if (!path.exists())
                return;
            if (path.isFile()) {
                path.delete();
                return;
            }
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteAllFilesOfDir(files[i]);
            }
            path.delete();
        }

        public final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
          
        /** 
         * 获取文件的MD5值 
         * @param file 
         * @return 
         */  
        public static String getFileMD5(File file){
            String md5 = null;  
            FileInputStream fis = null;
            FileChannel fileChannel = null;
            try {
                fis = new FileInputStream(file);
                fileChannel = fis.getChannel();
                // MappedByteBuffer: 其内容是文件的内存映射区域。映射的字节缓冲区是通过FileChannel.map 方法创建的。
                // 映射的字节缓冲区和它所表示的文件映射关系在该缓冲区本身成为垃圾回收缓冲区之前一直保持有效，并且没有提供关闭的方法。
                // 所以要手动清除
                MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(byteBuffer);
                    md5 = byteArrayToHexString(md.digest());
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                //手动清除buffer
                clean(byteBuffer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try {
                    fileChannel.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return md5;
        }

    /**
     * 使用Sun的Cleaner包（堆外内存的自动释放）清除数据
     * @param buffer
     * @throws Exception
     */
    public static void clean(final Object buffer) throws Exception {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Method getCleanerMethod = buffer.getClass().getMethod("cleaner",new Class[0]);
                    getCleanerMethod.setAccessible(true);
                    sun.misc.Cleaner cleaner =(sun.misc.Cleaner)getCleanerMethod.invoke(buffer,new Object[0]);
                    cleaner.clean();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                return null;}});

    }
          
        /** 
         * 字节数组转十六进制字符串 
         * @param digest 
         * @return 
         */  
        private static String byteArrayToHexString(byte[] digest) {  
              
            StringBuffer buffer = new StringBuffer();  
            for(int i=0; i<digest.length; i++){  
                buffer.append(byteToHexString(digest[i]));
            }
            return buffer.toString();  
        }  
          
        /** 
         * 字节转十六进制字符串 
         * @param b 
         * @return 
         */  
        private static String byteToHexString(byte b) {  
            //   取字节中高 4 位的数字转换
                 int d1 = (b&0xf0)>>4;
            //   取字节中低 4 位的数字转换
                 int d2 = b&0xf;  
                 return hexDigits[d1] + hexDigits[d2];  
        }

        //入口  
        public static void main(String [] args) throws Exception{

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
        con.setRequestProperty("Content-Type","application/json");
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

   /* *//**
     * 生成二维码
     * @param destFilePath  目标存放地址
     * @param fileName  生成二维码图片的名称
     * @param content    二维码所带的信息
     * @throws IOException
     * @throws WriterException
     *//*
    public static void makeQRCode(String destFilePath,String fileName,String content) throws IOException, WriterException {
        makeQRCode(destFilePath,fileName,content,200,200,"png");
    }
    //*//**
    // *  生成二维码
    // * @param destFilePath  目标存放地址
    // * @param fileName  生成二维码图片的名称
    // * @param content    二维码所带的信息
    // * @param width     二维码的高度
    // * @param height    二维码的宽度
    // * @param format    二维码的图片格式（png，jpg，jpge）
    // * @throws WriterException
    // * @throws IOException
    // *//*
    public static void  makeQRCode(String destFilePath,String fileName,String content,int width,int height,String format) throws WriterException, IOException {
        if (null != format && !(format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpeg"))) {
            System.out.println("您输入的图片格式不存在！");
            return;
        }
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN,1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        Path path = FileSystems.getDefault().getPath(destFilePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像

    }

    public static void mkQRCodeToStream(OutputStream stream,String content) throws WriterException, IOException {
        String format = "png";
        int width = 200,height=200 ;
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN,1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        MatrixToImageWriter.writeToStream(bitMatrix,format,stream);
//        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像*/
//    }

    public static  void mkNotFountImg(OutputStream stream,String message,int width,int height) throws IOException {
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D gs = image.createGraphics();
        gs.setBackground(Color.GREEN);
        gs.setFont(new Font("宋体", Font.BOLD + Font.ITALIC, 16));
        gs.setColor(Color.RED);
        int strWidth = gs.getFontMetrics().stringWidth(message);
        gs.drawString(message,( width - strWidth) / 2, height/2);
        ImageIO.write(image,"png",stream);
    }

}