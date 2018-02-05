package com.hengyi.xbaseandroiddemo.activity;

import android.os.Bundle;
import android.view.View;

import com.hengyi.baseandroidcore.dialog.CustomAlertDialog;
import com.hengyi.baseandroidcore.dialog.CustomConfirmDialog;
import com.hengyi.baseandroidcore.dialog.CustomDefaultDialogUtils;
import com.hengyi.baseandroidcore.utils.ActivityStack;
import com.hengyi.baseandroidcore.weight.EaseTitleBar;
import com.hengyi.xbaseandroiddemo.R;

import butterknife.BindView;
import butterknife.OnClick;

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

    @OnClick({R.id.btn_alert_dialog,R.id.btn_confirm_dialog,R.id.btn_loading_dialog,R.id.btn_de_loading_dialog})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_alert_dialog:
                alert();
                break;

            case R.id.btn_confirm_dialog:
                confirm();
                break;

            case R.id.btn_loading_dialog:
                loading();
                break;

            case R.id.btn_de_loading_dialog:
                loading_def();
                break;
        }
    }

    private void loading(){
        showLoadingDialog("正在加载");
        //closeLoadingDialog();
    }

    private void loading_def(){
        CustomDefaultDialogUtils.createWaitDialog(this,"正在加载",true,true);
    }


    private void confirm(){
        CustomConfirmDialog dialog = new CustomConfirmDialog(this).builder();
        dialog.setTitle("请输入您的手机号码");
        dialog.setInputNumber(false);

        dialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dialog.setPositiveButton("取消",new CustomConfirmDialog.OnPostListener(){

            @Override
            public void OnPost(String value) {
                toast(value);
            }
        });
        dialog.show();
    }

    private void alert(){
        CustomAlertDialog dialog = new CustomAlertDialog(this).builder();
        dialog.setTitle("温馨提示");
        dialog.setMsg("自定义弹窗高仿IOS，可以实现按钮文字自定义，显示或隐藏。");
        dialog.show();
    }

    @Override
    public int setContentView() {
        return R.layout.activity_dialog;
    }
}
