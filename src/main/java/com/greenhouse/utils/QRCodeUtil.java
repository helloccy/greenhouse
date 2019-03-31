package com.greenhouse.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 二维码工具
 * @author https://blog.csdn.net/Peng_Hong_fu/article/details/68068015
 */
public class QRCodeUtil {

    /**
     * 创建二维码，并转换为base64字符串
     * @param content 二维码内容
     */
    public static String createQRCodePng(String content) {
        int width=300;
        int height=300;
        String format="png";
        HashMap hits=new HashMap();
        hits.put(EncodeHintType.CHARACTER_SET, "utf-8");//编码
        //纠错等级，纠错等级越高存储信息越少
        hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //边距
        hits.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hits);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix,format,stream);
            return ("data:image/jpeg;base64," + new BASE64Encoder().encode(stream.toByteArray()))
                    .replaceAll("[\\s*\t\n\r]", "");//替换换行符
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建二维码，并存储
     * @param content 二维码内容。这里如果你想自动跳转的话，需要加上https://
     * @param pngFileAbsoName 二维码文件全路径，注意此文件必须存在，文件格式未png
     */
    public static boolean createQRCodePng(String content,String pngFileAbsoName) {
        int width=300;
        int height=300;
        String format="png";
        HashMap hits=new HashMap();
        hits.put(EncodeHintType.CHARACTER_SET, "utf-8");//编码
        //纠错等级，纠错等级越高存储信息越少
        hits.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //边距
        hits.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hits);
            //如果做网页版输出可以用输出到流
            //MatrixToImageWriter.writeToStream(matrix, format, stream);
            Path path=new File(pngFileAbsoName).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
