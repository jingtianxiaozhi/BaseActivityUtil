package com.xiaozhi.baseactivityutil.activity;

import android.os.Bundle;
import android.view.View;

import com.xiaozhi.baseactivityutil.R;

public class NewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    @Override
    public void initTitle() {
        setLeft(R.drawable.back_selector, this);
        setRight(R.drawable.ic_setting,this);
        setTitle("Center");
    }


    @Override
    public void onClick(View view) {
        super.titleClick(view);
    }
}
