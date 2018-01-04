package com.hengyi.xbaseandroiddemo.activity;

import android.os.Bundle;
import android.view.View;

import com.hengyi.baseandroidcore.utils.ActivityStack;
import com.hengyi.baseandroidcore.weight.EaseTitleBar;
import com.hengyi.xbaseandroiddemo.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/4.
 */

public class DialogActivity extends BaseActivity{
    @BindView(R.id.titleBar)EaseTitleBar titleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleBar.setLeftLayoutClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivityStack.getInstance().popActivity();//关闭当前界面
            }
        });
    }

    @Override
    public int setContentView() {
        return R.layout.activity_dialog;
    }
}
