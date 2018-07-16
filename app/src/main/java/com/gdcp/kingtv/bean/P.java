package com.gdcp.kingtv.bean;

/**
 * Created by asus- on 2018/7/8.
 */

class P {
    public static final int DEFAULT_SIZE = 10;

    private int page;

    private String key;

    private int categoryId;

    private int size = DEFAULT_SIZE;

    public P() {

    }

    public P(int page, String key) {
        this.page = page;
        this.key = key;
    }

    public P(int page, String key, int size) {
        this.page = page;
        this.key = key;
        this.size = size;
        //LogUtils.d(toString());
    }

    public P(int page, String key, int categoryId, int size) {
        this.page = page;
        this.key = key;
        this.categoryId = categoryId;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "P{" +
                "page=" + page +
                ", key='" + key + '\'' +
                ", categoryId=" + categoryId +
                ", size=" + size +
                '}';
    }
}
