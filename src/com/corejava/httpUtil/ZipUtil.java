package com.corejava.httpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 解压工具
 */
public class ZipUtil {
      
    @SuppressWarnings( { "unchecked", "static-access" })  
    public static void main(String[] args) {  
        /*ZipUtil z = new ZipUtil();
        ArrayList<String> a = z.Ectract("F:\\a.zip", "F:\\"); // 返回解压缩出来的文件列表
        for(String s : a){  
            System.out.println(s);  
        }
        // 要压缩的文件列表
        String path01 = "F:\\a";
        String path02 = "F:\\test.txt";
        try {
            FileOutputStream os = new FileOutputStream("F:\\a.zip"); // 输出的ZIP文件流
            z.compress(os, path01, path02);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        File copyFile = new File("F:\\test\\a.zip");
        File parent = copyFile.getParentFile();
        if (parent.exists()) {
           FileUtil.deleteAllFilesOfDir(parent);
        }
    }  
  
    /** 
     * 解压缩 
     * @param sZipPathFile 要解压的文件 
     * @param sDestPath 解压到某文件夹 
     * @return
     *          zip中文件名字的集合
     */  
    @SuppressWarnings("unchecked")  
    public static ArrayList Ectract(String sZipPathFile, String sDestPath) {  
        ArrayList<String> allFileName = new ArrayList<String>();  
        try {
            // 先指定压缩档的位置和档名，建立FileInputStream对象
            FileInputStream fins = new FileInputStream(sZipPathFile);
            // 将fins传入ZipInputStream中
            ZipInputStream zins = new ZipInputStream(fins);
            ZipEntry ze = null;
            byte[] ch = new byte[256];
            while ((ze = zins.getNextEntry()) != null) {
                File zfile = new File(sDestPath + ze.getName());
                File fpath = new File(zfile.getParentFile().getPath());
                if (ze.isDirectory()) {
                    if (!zfile.exists())
                        zfile.mkdirs();
                    zins.closeEntry();
                } else {
                    if (!fpath.exists())
                        fpath.mkdirs();
                    FileOutputStream fouts = new FileOutputStream(zfile);
                    int i;
                    allFileName.add(zfile.getAbsolutePath());
                    while ((i = zins.read(ch)) != -1)
                        fouts.write(ch, 0, i);
                    zins.closeEntry();
                    fouts.close();
                }
            }
            zins.close();
            fins.close();
        } catch (Exception e) {
            System.err.println("Extract error:" + e.getMessage());
        }
        return allFileName;  
    }

    /**
     * 压缩文件列表到某ZIP文件
     * @param zipFilename 要压缩到的ZIP文件
     * @param paths 文件列表，多参数
     * @throws Exception
     */
    public static void compress(String zipFilename, String... paths)
            throws Exception {
        compress(new FileOutputStream(zipFilename), paths);
    }

    /**
     * 压缩文件列表到输出流
     * @param os 要压缩到的流
     * @param paths 文件列表，多参数
     * @throws Exception
     */
    public static void compress(OutputStream os, String... paths)
            throws Exception {
        ZipOutputStream zos = new ZipOutputStream(os);
        for (String path : paths) {
            if (path.equals(""))
                continue;
            File file = new File(path);
            if (file.exists()) {
                if (file.isDirectory()) {
                    zipDirectory(zos, file.getPath(), file.getName()
                            + File.separator);
                } else {
                    zipFile(zos, file.getPath(), "");
                }
            }
        }
        zos.close();
    }

    private static void zipDirectory(ZipOutputStream zos, String dirName,
                                     String basePath) throws Exception {
        File dir = new File(dirName);
        if (dir.exists()) {
            File files[] = dir.listFiles();
            if (files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        zipDirectory(zos, file.getPath(), basePath
                                + file.getName().substring(
                                file.getName().lastIndexOf(
                                        File.separator) + 1)
                                + File.separator);
                    } else
                        zipFile(zos, file.getPath(), basePath);
                }
            } else {
                ZipEntry ze = new ZipEntry(basePath);
                zos.putNextEntry(ze);
            }
        }
    }

    private static void zipFile(ZipOutputStream zos, String filename,
                                String basePath) throws Exception {
        File file = new File(filename);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(filename);
            ZipEntry ze = new ZipEntry(basePath + file.getName());
            zos.putNextEntry(ze);
            byte[] buffer = new byte[8192];
            int count = 0;
            while ((count = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, count);
            }
            fis.close();
        }
    }
}  