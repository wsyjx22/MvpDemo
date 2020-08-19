package com.yjx.mvpdemo.data;

import com.yjx.mvpdemo.data.bean.WeatherInfo;

/**
* @ClassName: IInfoCallback
* @Description:
* @Author： edz
* @Date：2020/8/18 5:30 PM
*/
public interface IInfoCallback {

    void getWeatherSucceed(WeatherInfo info);

    void error(String msg);
}
