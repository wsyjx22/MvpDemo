package com.yjx.mvpdemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxbinding2.view.RxView;
import com.yjx.mvpdemo.base.BaseActivity;
import com.yjx.mvpdemo.data.bean.WeatherInfo;
import com.yjx.mvpdemo.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView {

    private ActivityMainBinding binding;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void weatherInfo(WeatherInfo info) {
        dismissLoading();
        binding.content.setText(info.toString());
    }

    @Override
    public void failed(String msg) {
        dismissLoading();
        Snackbar.make(binding.layout, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RxView.clicks(binding.startBtn).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        showLoading();
                        ((MainPresenter) presenter).getWeatherInfo();
                    }
                });
    }

}
