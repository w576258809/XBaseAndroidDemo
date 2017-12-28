package com.hengyi.xbaseandroiddemo;

import android.os.Bundle;

import com.hengyi.baseandroidcore.utilscode.LogUtils;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("安装日志","XBaseAndroid初始化成功");
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }
}
