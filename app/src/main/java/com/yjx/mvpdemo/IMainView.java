package com.yjx.mvpdemo;

import com.yjx.mvpdemo.data.bean.WeatherInfo;

/**
* @ClassName: IMainView
* @Description: MainActivity UI 接口
* @Author： edz
* @Date：2020/8/18 5:29 PM
*/
public interface IMainView {

    void weatherInfo(WeatherInfo info);

    void failed(String msg);

}
