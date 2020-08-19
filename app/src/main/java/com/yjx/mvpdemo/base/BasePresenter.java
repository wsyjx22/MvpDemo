package com.yjx.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
* @ClassName: BasePresenter
* @Description:
* @Author： edz
* @Date：2020/8/17 6:06 PM
*/
public abstract class BasePresenter<V> {

    protected WeakReference<V> reference;

    protected void attachView(V view) {
        reference = new WeakReference<>(view);
    }

    protected void detachView() {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }

    protected boolean isViewAttach() {
        return reference != null && reference.get() != null;
    }

    protected V getView() {
        if (isViewAttach()) {
            return reference.get();
        }
        return null;
    }

}
