package com.aoeng.leakcanary;


import android.app.IntentService;
import android.content.Intent;

public class LeakUploadService extends IntentService {


    public LeakUploadService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
