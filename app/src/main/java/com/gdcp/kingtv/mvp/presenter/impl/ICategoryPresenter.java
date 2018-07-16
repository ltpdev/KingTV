package com.gdcp.kingtv.mvp.presenter.impl;

import com.gdcp.kingtv.bean.LiveCategory;
import com.gdcp.kingtv.http.APIRetrofit;
import com.gdcp.kingtv.mvp.presenter.CategoryPresenter;
import com.gdcp.kingtv.mvp.view.ICategoryView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by asus- on 2018/7/8.
 */

public class ICategoryPresenter implements CategoryPresenter{
    private ICategoryView iCategoryView;

    public ICategoryPresenter(ICategoryView iCategoryView){
        this.iCategoryView=iCategoryView;
    }
    @Override
    public void getAllCategories() {
        APIRetrofit.getAPIService().getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LiveCategory>>() {
                    @Override
                    public void onCompleted() {
                        if (iCategoryView!=null){
                            iCategoryView.onCompleted();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCategoryView!=null){
                            iCategoryView.onError(e);
                        }
                    }

                    @Override
                    public void onNext(List<LiveCategory> liveCategories) {
                        if (iCategoryView!=null){
                            iCategoryView.onGetLiveCategory(liveCategories);
                        }
                    }
                });
    }

    @Override
    public void getAllCategoriesByDB() {

    }
}
