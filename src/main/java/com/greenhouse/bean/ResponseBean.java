package com.greenhouse.bean;

import com.greenhouse.common.ResponseBeanCode;
import com.greenhouse.common.ResponseBeanType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求响应Bean
 */
public class ResponseBean implements Serializable {
    /**
     * 错误类型
     */
    private String type ;
    /**
     * 错误码
     */
    private int code ;
    /**
     * 提示信息
     */
    private String message ;
    /**
     * 返回信息
     */
    private Map<String,Object> data = new HashMap<String, Object>();

    /**
     * 创建成功返回Bean
     * @return
     */
    public static ResponseBean createSuccess(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.type = ResponseBeanType.SUCCESS ;
        responseBean.code = ResponseBeanCode.SUCCESS ;
        responseBean.message = "SUCCESS" ;
        return responseBean;
    }
    /**
     * 创建失败返回Bean
     * @param message
     * @return
     */
    public static ResponseBean createError(String message){
        ResponseBean responseBean = new ResponseBean();
        responseBean.type = ResponseBeanType.ERROR ;
        responseBean.code = ResponseBeanCode.ERROR ;
        responseBean.message = message ;
        return responseBean;
    }
    /**
     * 创建异常返回Bean
     * @param message
     * @return
     */
    public static ResponseBean createException(String message){
        ResponseBean responseBean = new ResponseBean();
        responseBean.type = ResponseBeanType.EXCEPTION ;
        responseBean.code = ResponseBeanCode.EXCEPTION ;
        responseBean.message = message ;
        return responseBean;
    }
    /**
     * 创建警告返回Bean
     * @param message
     * @return
     */
    public static ResponseBean createWarn(String message) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.type = ResponseBeanType.WARN ;
        responseBean.code = ResponseBeanCode.WARN ;
        responseBean.message = message ;
        return responseBean;
    }

    /**
     * 创建未登录返回Bean
     * @param message
     * @return
     */
    public static ResponseBean createNoLogin(String message){
        ResponseBean responseBean = new ResponseBean();
        responseBean.type = ResponseBeanType.ERROR ;
        responseBean.code = ResponseBeanCode.NO_LOGIN ;
        responseBean.message = message ;
        return responseBean;
    }


    public Object getData(String key){
        return this.data.get(key);
    }

    public String getType() {
        return type;
    }

    public ResponseBean setType(String type) {
        this.type = type;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseBean setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public ResponseBean setData(String key,Object obj){
        this.data.put(key,obj);
        return this;
    }

    public ResponseBean addData(String key,Object obj){
        this.data.put(key,obj);
        return this;
    }


}
