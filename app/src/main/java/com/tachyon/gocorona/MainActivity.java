package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_main);
        PrefManager prefManager = new PrefManager(getApplicationContext());
        if(prefManager.isFirstTimeLaunch()){
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        }

        View v1 = findViewById(R.id.item1);
        View v2 = findViewById(R.id.item2);
        View v3 = findViewById(R.id.item3);
        View v4 = findViewById(R.id.item4);

        TextView t1 = v1.findViewById(R.id.top_bar_text);
        TextView t2 = v2.findViewById(R.id.top_bar_text);
        TextView t3 = v3.findViewById(R.id.top_bar_text);
        TextView t4 = v4.findViewById(R.id.top_bar_text);

        ImageView i1 = v1.findViewById(R.id.top_bar_img);
        ImageView i2 = v2.findViewById(R.id.top_bar_img);
        ImageView i3 = v3.findViewById(R.id.top_bar_img);
        ImageView i4 = v4.findViewById(R.id.top_bar_img);

        t1.setText("Symptoms");
        t2.setText("Do's and Don't");
        t3.setText("Helpline");
        t4.setText("Statistics");

        i1.setImageResource(R.drawable.coughing_1);
        i2.setImageResource(R.drawable.washing_hands1);
        i3.setImageResource(R.drawable.mobile_phone1);
        i4.setImageResource(R.drawable.asia);
    }
}
