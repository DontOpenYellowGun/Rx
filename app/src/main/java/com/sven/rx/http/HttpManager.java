package com.sven.rx.http;

import com.sven.rx.model.Bean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Sven on 2016/12/1.
 */

public interface HttpManager {

    @GET("all/20/{page}")
    Observable<Bean> getData(@Path("page") int page);
}
