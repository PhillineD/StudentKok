/**
 * Navigation class, choose between new or history.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */


package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.phill.studentcheff.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    /**
     * Navigation to Vactivity.
     *
     * @param view    Represents a view of the button "Try something new".
     */
    public void clickNew(View view) {
        Intent intent = new Intent(getApplicationContext(), VActivity.class);
        startActivity(intent);
    }

    /**
     * Navigation to History.
     *
     * @param view    Represents a view of the button "History" .
     */
    public void clickHistory(View view) {
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

}
