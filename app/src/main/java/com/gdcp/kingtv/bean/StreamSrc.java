package com.gdcp.kingtv.bean;

/**
 * Created by asus- on 2018/7/8.
 */

class StreamSrc {
    private String name;
    private String src;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "StreamSrc{" +
                "name='" + name + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
