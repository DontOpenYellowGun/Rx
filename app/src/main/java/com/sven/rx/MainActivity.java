package com.sven.rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sven.rx.http.HttpManager;
import com.sven.rx.model.Bean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/data/")
                .addConverterFactory(GsonConverterFactory.create())//构造解析对象Gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        HttpManager httpManager = retrofit.create(HttpManager.class);
        Observable<Bean> observable = httpManager.getData(1);

        observable.subscribeOn(Schedulers.io())//在io线程执行数据操作
                .observeOn(AndroidSchedulers.mainThread())//在主线程发出通知
                //获取bean中集合
                .map(new Func1<Bean, List<Bean.ResultsBean>>() {
                    @Override
                    public List<Bean.ResultsBean> call(Bean gankResultBean) {
                        return gankResultBean.getResults();
                    }
                })
                //list<ResultsBean>转化成多个resultsBean类型的观察者
                .flatMap(new Func1<List<Bean.ResultsBean>, Observable<Bean.ResultsBean>>() {
                    @Override
                    public Observable<Bean.ResultsBean> call(List<Bean.ResultsBean> resultsBeen) {

                        return Observable.from(resultsBeen);
                    }
                })
                //根据集合中的字段筛选
                .filter(new Func1<Bean.ResultsBean, Boolean>() {
                    @Override
                    public Boolean call(Bean.ResultsBean resultsBean) {
                        return "Android".equals(resultsBean.getType());
                    }
                })
                .subscribe(new Subscriber<Bean.ResultsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("MainActivity", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MainActivity", "onError");
                        Log.e("MainActivity", e.getMessage());
                        Log.e("MainActivity", e.getLocalizedMessage());
                        Log.e("MainActivity", String.valueOf(e.getCause()));
                    }

                    @Override
                    public void onNext(Bean.ResultsBean resultsBean) {
                        Log.e("MainActivity", resultsBean.toString());
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_edit:
                Toast.makeText(this, "action_edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "action_share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
