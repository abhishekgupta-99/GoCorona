package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GO_OUT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__out);

        Bundle bundle = getIntent().getExtras();
        String account_name=bundle.getString("user_name");
        TextView user=findViewById(R.id.signedIn);
        user.setText(account_name);
    }
}
