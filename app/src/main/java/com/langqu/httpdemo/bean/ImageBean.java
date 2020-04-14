package com.langqu.httpdemo.bean;

import java.util.List;

/**
 * @author: ruan
 * @date: 2020/4/14
 */
public class ImageBean {


    /**
     * code : 10000
     * data : []
     */

    private int code;
    private List<?> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
