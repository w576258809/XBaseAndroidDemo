package com.hengyi.xbaseandroiddemo.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.hengyi.baseandroidcore.base.XBaseActivity;
import com.hengyi.baseandroidcore.statusbar.StatusBarCompat;
import com.hengyi.baseandroidcore.utils.ColorUtils;
import com.hengyi.xbaseandroiddemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends XBaseActivity {
    private Unbinder unbind = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor(ColorUtils.changeColor(this, R.color.main_color)));
        unbind = ButterKnife.bind(this);
    }

    @Override
    public int setBaseContentView() {
        return setContentView();
    }

    public abstract int setContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }
}
