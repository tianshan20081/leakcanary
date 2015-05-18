package com.aoeng.leakcanary.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.aoeng.leakcanary.R;
import com.aoeng.leakcanary.application.MyMpplication;
import com.squareup.leakcanary.RefWatcher;

public class TestUI extends Activity {

    private TextView tv;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ui);
        RefWatcher refWatcher = MyMpplication.getRefWatcher(this);
        refWatcher.watch(this);
        tv = (TextView) findViewById(R.id.tvTest);
//        TestDataModel.getInstance(this).setRetainedTextView(tv);

        handler.postDelayed(postRunnable,8000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        TestDataModel.getInstance(this).removeTextView();
        handler.removeCallbacks(null);
    }

    private Runnable postRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d(TestUI.class.getName(),"hander");
        }
    };
}
