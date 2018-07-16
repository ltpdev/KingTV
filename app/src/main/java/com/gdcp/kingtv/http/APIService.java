package com.gdcp.kingtv.http;

import com.gdcp.kingtv.bean.AppStart;
import com.gdcp.kingtv.bean.LiveCategory;
import com.gdcp.kingtv.bean.LiveListResult;
import com.gdcp.kingtv.bean.Recommend;
import com.gdcp.kingtv.bean.Room;
import com.gdcp.kingtv.bean.SearchRequestBody;
import com.gdcp.kingtv.bean.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 网络请求接口
 */

public interface APIService{
    //获取app启动页信息页
    @GET("json/page/app-data/info.json?v=3.0.1&os=1&ver=4")
    Observable<AppStart>getAppStartInfo();
    //获取分类列表
    @GET("json/app/index/category/info-android.json?v=3.0.1&os=1&ver=4")
    Observable<List<LiveCategory>>getAllCategories();
    //获取推荐列表
    @GET("json/app/index/recommend/list-android.json?v=3.0.1&os=1&ver=4")
    Observable<Recommend> getRecommend();
    /**
     * 获取直播列表.
     * @return
     */
    @GET("json/play/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveListResult();


    //根据分类获取直播列表

    @GET("json/categories/{slug}/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveListResultByCategories(@Path("slug") String slug);
    /**
     * 进入房间
     * @param uid
     * @return
     */
    @GET("json/rooms/{uid}/info.json?v=3.0.1&os=1&ver=4")
    Observable<Room> enterRoom(@Path("uid")String uid);

    //搜索
    @POST("site/search")
    Observable<SearchResult>search(@Body SearchRequestBody searchRequestBody);


}
