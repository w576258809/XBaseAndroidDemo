package com.hengyi.xbaseandroiddemo.activity;

import android.os.Bundle;
import android.view.View;

import com.hengyi.baseandroidcore.utils.ActivityStack;
import com.hengyi.baseandroidcore.utils.ActivityUtils;
import com.hengyi.baseandroidcore.utilscode.LogUtils;
import com.hengyi.baseandroidcore.weight.EaseTitleBar;
import com.hengyi.xbaseandroiddemo.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.titleBar)EaseTitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("安装日志","XBaseAndroid初始化成功");
        titleBar.setLeftLayoutClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivityStack.getInstance().popActivity();//关闭当前界面
                ActivityUtils.kill();//杀死当前APP进程
            }
        });
    }

    @OnClick({R.id.btn_dialog})
    public void OnClick(View view){
        switch(view.getId()){
            case R.id.btn_dialog:
                ActivityUtils.StartActivity(this,DialogActivity.class);
                break;
        }
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }
}
