package com.terryyamg.lollipopnotificationtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        TextView tvDetail = (TextView)findViewById(R.id.tvDetail);
        tvDetail.setText("跳進來了");
    }
}
