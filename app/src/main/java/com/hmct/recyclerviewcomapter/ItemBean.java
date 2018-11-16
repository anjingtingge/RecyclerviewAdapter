package com.hmct.recyclerviewcomapter;

/**
 * Created by wangyajie on 2018/8/2.
 */

public class ItemBean {
    //R.drawable....
    private String url;
    private String desc;

    public ItemBean(String url, String desc){
        this.url = url;
        this.desc = desc;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
