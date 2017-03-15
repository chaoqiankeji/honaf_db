package com.honaf.honaf_db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    public static final String TAG = "honaf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_add, R.id.btn_del, R.id.btn_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Developer developer = new Developer();
                developer.setId("0");
                developer.setAge(18);
                developer.setName("honaf");
                developer.setCompany(new Company());
                long result = DBManager.getInstance(this).newOrUpdate(developer);
                Log.d(TAG, result + "");
                break;
            case R.id.btn_del:
                break;
            case R.id.btn_query:
                Developer developer1 = DBManager.getInstance(this).queryById("0");
                Log.d(TAG, developer1 != null ? developer1.toString() : "");
                break;
        }
    }
}
