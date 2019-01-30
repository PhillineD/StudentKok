/**
 * Navigation class, choose between new or history or give information.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */


package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.phill.studentcheff.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    /**
     * Navigation to right page.
     *
     * @param v    Represents a view of the buttons.
     */
    public void onClick(View v) {
        switch (v.getId()) {

            // navigation to Vactivity
            case R.id.newmeal:
                Intent intentNew = new Intent(getApplicationContext(), VActivity.class);
                startActivity(intentNew);
                break;

            // navigation to History
            case R.id.history:
                Intent intentHistory = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intentHistory);
                break;

            // open browser with database site
            case R.id.internet:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.themealdb.com/"));
                startActivity(browserIntent);
                break;

            // give pop up  with info
            case R.id.information:

                //  code from: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android.
                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_history, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true;

                // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
                break;
        }

    }
}
