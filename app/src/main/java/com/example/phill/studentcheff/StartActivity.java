package com.example.phill.studentcheff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    public void clicknew(View view) {
        Intent intent = new Intent(getApplicationContext(), VActivity.class);
        startActivity(intent);
    }


    public void clickhistory(View view) {
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

}
