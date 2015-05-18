package com.aoeng.leakcanary.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoeng.leakcanary.R;
import com.aoeng.leakcanary.application.MyMpplication;
import com.squareup.leakcanary.RefWatcher;


public class HomeUI extends Activity {

    private ImageView ivOom;
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);

        RefWatcher refWatcher = MyMpplication.getRefWatcher(this);
        refWatcher.watch(this);

        tvMsg = (TextView)findViewById(R.id.tvMsg);
//        TestDataModel.getInstance(this.getApplicationContext()).setRetainedTextView(tvMsg);

        findViewById(R.id.btnNewActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeUI.this, TestUI.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ivOom = null ;
//        TestDataModel.getInstance(this.getApplicationContext()).removeTextView();
    }
}
