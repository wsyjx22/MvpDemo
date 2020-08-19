package com.yjx.mvpdemo.data.model;

import com.allen.library.RxHttpUtils;
import com.yjx.mvpdemo.data.IInfoCallback;
import com.yjx.mvpdemo.data.bean.WeatherInfo;
import com.yjx.mvpdemo.net.ApiService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
* @ClassName: WeatherInfoModel
* @Description: Model
* @Author： edz
* @Date：2020/8/18 5:30 PM
*/
public class WeatherInfoModel {

    private IInfoCallback callback;
    private final CompositeDisposable disposables = new CompositeDisposable();

    public WeatherInfoModel(IInfoCallback callback) {
        this.callback = callback;
    }

    public void requestWeatherInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("appid", "81457676");
        map.put("appsecret", "YaN314Oj");
        map.put("city", "北京");
        RxHttpUtils.createApi(ApiService.class)
                .getWeatherInfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposables.add(d);
            }

            @Override
            public void onNext(WeatherInfo info) {
                callback.getWeatherSucceed(info);
            }

            @Override
            public void onError(Throwable e) {
                callback.error("请求失败");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void release() {
        disposables.clear();
    }

}
