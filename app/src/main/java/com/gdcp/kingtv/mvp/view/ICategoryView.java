package com.gdcp.kingtv.mvp.view;

import com.gdcp.kingtv.bean.LiveCategory;

import java.util.List;

/**
 * Created by asus- on 2018/7/8.
 */

public interface ICategoryView {
    void onGetLiveCategory(List<LiveCategory> list);

    void onError(Throwable e);

    void onCompleted();
}
