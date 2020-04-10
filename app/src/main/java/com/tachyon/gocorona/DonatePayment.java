package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DonatePayment extends AppCompatActivity {

    TextView title_topbar,title_main,descprition;
    ImageView close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }

        setContentView(R.layout.activity_donate_payment);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String desc = bundle.getString("desc");

        title_main = findViewById(R.id.donate_title_2);
        title_topbar = findViewById(R.id.donate_title_1);
        descprition = findViewById(R.id.donate_desc_1);
        close = findViewById(R.id.donate_close);

        title_main.setText(title);
        title_topbar.setText(title);
        descprition.setText(desc);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
