package com.xiaozhi.baseactivityutil.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xiaozhi.baseactivityutil.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initTitle() {
        setLeft("左边", this);
        setRight("右边",this);
        setTitle("中间");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout_left:{
                Toast.makeText(MainActivity.this, "点击左边！", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.layout_right:{
                Toast.makeText(MainActivity.this, "点击右边！", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}
