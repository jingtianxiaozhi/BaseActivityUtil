package com.xiaozhi.baseactivityutil.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaozhi.baseactivityutil.R;
import com.xiaozhi.baseactivityutil.application.MyApplication;
import com.xiaozhi.baseactivityutil.eventbus.CareEvent;
import com.xiaozhi.baseactivityutil.eventbus.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusUtil.register(this);
        MyApplication.addActivity(this);
        addTitle();
        initTitle();
    }

    private void addTitle() {
        ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
        contentView.removeAllViews();
        contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        contentView.addView(contentLayout);
        LayoutInflater.from(this).inflate(R.layout.public_title, contentLayout, true);
    }

    public abstract void initTitle();

    public void setTitle(String titleText) {
        findViewById(R.id.tv_title).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_title)).setText(titleText);
    }

    public void setLeft(int resId, View.OnClickListener leftOncliclListener) {
        findViewById(R.id.iv_left).setVisibility(View.VISIBLE);
        findViewById(R.id.iv_left).setBackgroundResource(resId);
        findViewById(R.id.layout_left).setOnClickListener(leftOncliclListener);
    }

    public void setLeft(String leftText, View.OnClickListener leftOncliclListener) {
        findViewById(R.id.tv_left).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_left)).setText(leftText);
        findViewById(R.id.layout_left).setOnClickListener(leftOncliclListener);
    }

    public void setRight(int resId, View.OnClickListener rightOncliclListener) {
        findViewById(R.id.iv_right).setVisibility(View.VISIBLE);
        findViewById(R.id.iv_right).setBackgroundResource(resId);
        findViewById(R.id.layout_right).setOnClickListener(rightOncliclListener);
    }

    public void setRight(String rightText, View.OnClickListener rightOncliclListener) {
        findViewById(R.id.tv_right).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_right)).setText(rightText);
        findViewById(R.id.layout_right).setOnClickListener(rightOncliclListener);
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, contentLayout, true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CareEvent careEvent) {

    }

    public void titleClick(View view) {
        switch (view.getId()){
            case R.id.layout_left:{
                Toast.makeText(this, "点击左边！", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.layout_right:{
                Toast.makeText(this, "点击右边！", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
        MyApplication.removeActivity(this);
    }
}
