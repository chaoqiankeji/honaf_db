package com.honaf.honaf_db;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    public static final String TAG = "honaf";
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_del)
    Button btnDel;
    @BindView(R.id.btn_query)
    Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_add, R.id.btn_del, R.id.btn_query})
    public void onClick(View view) {
        handler.sendEmptyMessage(1);
        switch (view.getId()) {
            case R.id.btn_add:
                Developer developer = new Developer();
                developer.setId("1");
                developer.setAge(18);
                developer.setName("honaf");
                developer.setCompany(new Company());
                long result = DBManager.getInstance(this).newOrUpdate(developer);
                Log.d(TAG, result + "");
                break;
            case R.id.btn_del:
                break;
            case R.id.btn_query:
                Developer developer1 = DBManager.getInstance(this).queryById("1");
                Log.d(TAG, developer1 != null ? developer1.toString() : "");
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);


        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
