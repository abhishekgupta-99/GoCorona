package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Boolean login = sh.getBoolean("Login",false);

        if(!login)
        {
            startActivity(new Intent(MainActivity.this,SignIn.class));
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

        TextView blood = findViewById(R.id.blood_text);
        TextView money = findViewById(R.id.money_text);
        TextView food = findViewById(R.id.food_text);

        blood.setText("Blood");
        money.setText("Money");
        food.setText("Food");

        blood.setTextColor(getResources().getColor(R.color.red_text));
        money.setTextColor(getResources().getColor(R.color.yellow_text));
        food.setTextColor(getResources().getColor(R.color.green_text));

        ImageView blood_img = findViewById(R.id.blood_img);
        ImageView money_img = findViewById(R.id.money_img);
        ImageView food_img = findViewById(R.id.food_img);

        blood_img.setImageResource(R.drawable.blood);
        money_img.setImageResource(R.drawable.money);
        food_img.setImageResource(R.drawable.food);

        MaterialCardView blood_card = findViewById(R.id.donate_blood);
        MaterialCardView money_card = findViewById(R.id.donate_money);
        MaterialCardView food_card = findViewById(R.id.donate_food);

        blood_card.setCardBackgroundColor(getResources().getColor(R.color.red_donate_back));
        money_card.setCardBackgroundColor(getResources().getColor(R.color.yellow_donate_back));
        food_card.setCardBackgroundColor(getResources().getColor(R.color.green_donate_back));

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SymptomsActivity.class));
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HelplineActivity.class));
            }
        });

        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StatsActivity.class));
            }
        });

        MaterialCardView pass = findViewById(R.id.travel_pass);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GO_OUT.class));
            }
        });
    }

    public void donate_money(View view) {

        startActivity(new Intent(this,Donate_Amount.class));

    }
}
