package com.gdcp.kingtv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gdcp.kingtv.bean.AppStart;
import com.gdcp.kingtv.bean.LiveListResult;
import com.gdcp.kingtv.bean.Recommend;
import com.gdcp.kingtv.http.APIRetrofit;
import com.gdcp.kingtv.http.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      APIRetrofit.getAPIService().getLiveListResult().subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<LiveListResult>() {
                  @Override
                  public void onCompleted() {
                      Log.i("DataBean","onCompleted");
                      Toast.makeText(MainActivity.this,"onCompleted",Toast.LENGTH_SHORT).show();
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onNext(LiveListResult liveListResult) {

                      LiveListResult.RecommendBean recommend=liveListResult.getRecommend();
                      List<LiveListResult.RecommendBean.DataBean> dataBeans=recommend.getData();
                      for (LiveListResult.RecommendBean.DataBean dataBean:dataBeans) {
                          Log.i("DataBean",dataBean.getFk()+"&"+dataBean.getCreate_at());
                      }
                  }
              });


    }
}
