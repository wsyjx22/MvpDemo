package com.yjx.mvpdemo;

import com.yjx.mvpdemo.base.BasePresenter;
import com.yjx.mvpdemo.data.IInfoCallback;
import com.yjx.mvpdemo.data.bean.WeatherInfo;
import com.yjx.mvpdemo.data.model.WeatherInfoModel;

/**
* @ClassName: MainPresenter
* @Description:
* @Author： edz
* @Date：2020/8/17 7:00 PM
*/
public class MainPresenter extends BasePresenter<IMainView> implements IInfoCallback {

    private WeatherInfoModel model;

    public MainPresenter(IMainView view) {
        attachView(view);
        model = new WeatherInfoModel(this);
    }

    public void getWeatherInfo() {
        model.requestWeatherInfo();
    }

    @Override
    public void getWeatherSucceed(WeatherInfo info) {
        if (isViewAttach()) {
            getView().weatherInfo(info);
        }
    }

    @Override
    public void error(String msg) {
        if (isViewAttach()) {
            getView().failed(msg);
        }
    }

    @Override
    protected void detachView() {
        super.detachView();
        model.release();
    }
}
