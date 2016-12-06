package com.example.lixiang.rxjavatest.api;

import com.example.lixiang.rxjavatest.data.JokeItemData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lixiang on 2016/11/12.
 */

public interface JokeItemService {

    String BASE_URL = "http://japi.juhe.cn/joke/content/";

    @GET("text.from")
    Observable<JokeItemData> getJokeData(@Query("page") int page, @Query("pagesize") int pagesize, @Query("key") String key);

}
