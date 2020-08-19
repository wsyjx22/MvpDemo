package com.yjx.mvpdemo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @ClassName: BaseActivity
 * @Description:
 * @Author： edz
 * @Date：2020/8/17 1:39 PM
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends FragmentActivity {

    protected LoadingDialogFragment loadingDialogFragment;
    protected BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    protected abstract P createPresenter();

    protected void showLoading() {
        loadingDialogFragment = (LoadingDialogFragment) getSupportFragmentManager().findFragmentByTag("Loading");
        if (loadingDialogFragment == null) {
            loadingDialogFragment = new LoadingDialogFragment();
        }
        if (!loadingDialogFragment.isAdded()) {
            loadingDialogFragment.show(getSupportFragmentManager(), "Loading");
        }
    }

    protected void dismissLoading() {
        if (loadingDialogFragment != null) {
            loadingDialogFragment.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        dismissLoading();
        presenter.detachView();
        super.onDestroy();
    }
}
