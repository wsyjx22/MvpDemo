package com.yjx.mvpdemo.net;

import com.yjx.mvpdemo.data.bean.WeatherInfo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("/free/day")
    Observable<WeatherInfo> getWeatherInfo(@QueryMap Map<String, String> map);

}
