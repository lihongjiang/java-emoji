package com.supets.pet.utls;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Java-emoji
 *
 * @user lihongjiang
 * @description
 * @date 2016/12/23
 * @updatetime 2016/12/23
 */

public class DataBaseCopyUtils {

    public static void copyDBToSDcrad()
    {
        String DATABASE_NAME = "emoji_cache";

        String oldPath = "data/data/com.supets.pet.java_emoji/databases/" + DATABASE_NAME;
        String newPath = Environment.getExternalStorageDirectory() + File.separator + DATABASE_NAME;

        copyFile(oldPath, newPath);
    }

    /**
     * 复制单个文件
     *
     * @param oldPath
     *            String 原文件路径
     * @param newPath
     *            String 复制后路径
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath)
    {
        try
        {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            File newfile = new File(newPath);
            if (!newfile.exists())
            {
                newfile.createNewFile();
            }
            if (oldfile.exists())
            { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1)
                {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }

}
