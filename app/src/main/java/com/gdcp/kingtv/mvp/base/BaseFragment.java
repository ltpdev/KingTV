package com.gdcp.kingtv.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdcp.kingtv.bean.LiveCategory;
import com.gdcp.kingtv.mvp.presenter.CategoryPresenter;
import com.gdcp.kingtv.mvp.presenter.impl.ICategoryPresenter;
import com.gdcp.kingtv.mvp.view.ICategoryView;

import java.util.List;

/**
 * Created by asus- on 2018/7/8.
 */

public class  BaseFragment extends Fragment implements ICategoryView{
    private CategoryPresenter categoryPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryPresenter=new ICategoryPresenter(this);
        categoryPresenter.getAllCategories();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onGetLiveCategory(List<LiveCategory> list) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}
