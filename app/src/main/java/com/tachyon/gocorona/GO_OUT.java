package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class GO_OUT extends AppCompatActivity {
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__out);

        //Bundle bundle = getIntent().getExtras();

        sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String account_name=sh.getString("user_name","");

        TextView user=findViewById(R.id.signedIn);
        user.setText(account_name);
    }
}
