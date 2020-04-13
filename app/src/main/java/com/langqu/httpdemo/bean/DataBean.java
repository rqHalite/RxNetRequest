package com.langqu.httpdemo.bean;

import com.langqu.httpdemo.R;

import java.util.ArrayList;
import java.util.List;

public class DataBean {

    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getTestData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean(R.drawable.ic_launcher_background, "相信自己,你努力的样子真的很美", 1));
        list.add(new DataBean(R.drawable.ic_launcher_background, "极致简约,梦幻小屋", 3));
        list.add(new DataBean(R.drawable.ic_launcher_background, "超级卖梦人", 3));
        list.add(new DataBean(R.drawable.ic_launcher_background, "夏季新搭配", 1));
        list.add(new DataBean(R.drawable.ic_launcher_background, "绝美风格搭配", 1));
        list.add(new DataBean(R.drawable.ic_launcher_background, "微微一笑 很倾城", 3));
        return list;
    }
}
