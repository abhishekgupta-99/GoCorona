package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.tachyon.gocorona.Adapters.HelplineAdapter;

import java.util.ArrayList;
import java.util.List;

public class HelplineActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    HelplineAdapter helplineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_helpline);

        recyclerView = (RecyclerView) findViewById(R.id.helpline_recycler);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> state = new ArrayList<>();
        ArrayList<String> num = new ArrayList<>();

        state.add("Andhra Pradesh ");
        state.add("Arunachal Pradesh ");
        state.add("Assam ");
        state.add("Bihar ");
        state.add("Chhattisgarh ");
        state.add("Goa ");
        state.add("Gujarat ");
        state.add("Haryana ");
        state.add("Himachal Pradesh ");
        state.add("Jharkhand ");
        state.add("Karnataka ");
        state.add("Kerala ");
        state.add("Madhya Pradesh  ");
        state.add("Maharashtra ");
        state.add("Manipur ");
        state.add("Meghalaya ");
        state.add("Mizoram ");
        state.add("Nagaland ");
        state.add("Odisha ");
        state.add("Punjab ");
        state.add("Rajasthan ");
        state.add("Sikkim ");
        state.add("Tamil Nadu ");
        state.add("Telangana ");
        state.add("Tripura ");
        state.add("Uttarakhand ");
        state.add("Uttar Pradesh  ");
        state.add("West Bengal   ");
        state.add("Andaman and Nicobar Islands ");
        state.add("Chandigarh ");
        state.add("Dadra and Nagar Haveli and Daman & Diu ");
        state.add("Delhi ");
        state.add("Jammu & Kashmir ");
        state.add("Ladakh ");
        state.add("Lakshadweep ");
        state.add("Puducherry ");

        num.add("0866-2410978");
        num.add("9436055743");
        num.add("6913347770 ");
        num.add("104 ");
        num.add("104 ");
        num.add("104 ");
        num.add("104 ");
        num.add("8558893911 ");
        num.add("104 ");
        num.add("104 ");
        num.add("104 ");
        num.add("0471-2552056 ");
        num.add("104 ");
        num.add("020-26127394 ");
        num.add("3852411668 ");
        num.add("108 ");
        num.add("102 ");
        num.add("7005539653 ");
        num.add("9439994859 ");
        num.add("104 ");
        num.add("0141-2225624 ");
        num.add("104 ");
        num.add("044-29510500 ");
        num.add("104 ");
        num.add("0381-2315879 ");
        num.add("104 ");
        num.add("18001805145");
        num.add("1800313444222  ");
        num.add("03192-232102");
        num.add("9779558282 ");
        num.add("104");
        num.add("011-22307145 ");
        num.add("01912520982 ");
        num.add("01982256462 ");
        num.add("104 ");
        num.add("104 ");

        helplineAdapter = new HelplineAdapter(this,state,num);
        recyclerView.setAdapter(helplineAdapter);

    }
}
