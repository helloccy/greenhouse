package com.greenhouse.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Generator {

    /**
     * 生成唯一的保存到磁盘上的文件名
     * @return
     */
    public static String generateUniqueName(){
        String fileName = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        fileName = sdf.format(new Date());

        Random r = new Random();
        for(int i=0; i<3; i++){
            fileName += r.nextInt(10);
        }

        return fileName;

    }
}