package com.aoeng.leakcanary.datas;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by sczhang on 15/5/11.
 */
public class TestDataModel {
    private static TestDataModel instance;
    private TextView mTv;
    private Context mContext;

    private TestDataModel(Context context) {
        this.mContext = context;
    }

    public static TestDataModel getInstance(Context context) {
        if (null == instance) {
            instance = new TestDataModel(context);
        }
        return instance;
    }

    public void setRetainedTextView(TextView tv) {
        this.mTv = tv;
        tv.setText("text");
    }

    public void removeTextView() {
        mTv = null;
    }

}
