package com.langqu.httpdemo.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: ruan
 * @date: 2020/4/16
 */
@Entity
public class TestDaoBean {

    public String id;

    public String url;

    @Generated(hash = 105674464)
    public TestDaoBean(String id, String url) {
        this.id = id;
        this.url = url;
    }

    @Generated(hash = 650418494)
    public TestDaoBean() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
