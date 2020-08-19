package com.yjx.mvpdemo.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.yjx.mvpdemo.R;

/**
* @ClassName: LoadingDialogFragment
* @Description: loading
* @Author： yjx
* @Date：2020/8/17 1:28 PM
*/
public class LoadingDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("加载中");
        builder.setView(R.layout.dialog_loading);
        return builder.create();
    }

}
