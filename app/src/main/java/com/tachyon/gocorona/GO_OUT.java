package com.tachyon.gocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

import java.util.Calendar;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.view.View.GONE;

public class GO_OUT extends AppCompatActivity {
    EditText date,time,destination,destin_add;
    ChipGroup chipGroup;
    String chiptype;
    private EditText consulting_Dr;
    SharedPreferences sharedPreferences;
    String account_name;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__out);
         time=findViewById(R.id.time);
         date=findViewById(R.id.date);
        destination =findViewById(R.id.dest);
        destin_add =findViewById(R.id.dest_add);
         chipGroup = findViewById(R.id.chip_group);
         progress = new ProgressDialog(this);
         consulting_Dr=findViewById(R.id.dr);
//        Bundle bundle = getIntent().getExtras();
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        account_name=sharedPreferences.getString("user_name","Abhishek Gupta");
        TextView user=findViewById(R.id.signedIn);
        user.setText(account_name);
        initialize_spinners_medical();

       chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(ChipGroup group, int checkedId) {

         chiptype = group.findViewById(checkedId).toString();
        chiptype = chiptype.substring(chiptype.indexOf('/') + 1, chiptype.indexOf('}'));


        switch (chiptype+"")
        {
            case "medical":

                initialize_spinners_medical();

                break;

            case "groceries":
                initialize_spinners_groceries();

                break;
            case "vol":
                initialize_spinners_volunteer();

                break;
            default:

                break;


        }

    }
});

    }

    private void initialize_spinners_volunteer() {
        destination.setHint("NGO to volunteer");
        destin_add.setHint("Donation Drive At");
        consulting_Dr.setVisibility(GONE);

        String[] no = new String[] {"1", "2"};
        String[] hospitals=new String[] {"ASHA EK HOPE","Ujala","India Fights Back","Fighting Corona"};



        ArrayAdapter<String> adapter_accompany =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        no);

        ArrayAdapter<String> adapter_hospital =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        hospitals);


//        ArrayAdapter<String> adapter_sub =
//                new ArrayAdapter<>(
//                        this,
//                        R.layout.dropdown_menu_popup_item,
//                        BookFragment.getSubject_names_clone());

        AutoCompleteTextView editTextFilledExposedDropdown1 =
                findViewById(R.id.number_of_memb);
        editTextFilledExposedDropdown1.setAdapter(adapter_accompany);



        AutoCompleteTextView editTextFilledExposedDropdown2 =
                findViewById(R.id.dest);
        editTextFilledExposedDropdown2.setAdapter(adapter_hospital);




    }

    Runnable progressRunnable = new Runnable() {

        @Override
        public void run() {
            progress.cancel();
        }
    };

    private void initialize_spinners_groceries() {
        destination.setHint("Nearby Market");
        destin_add.setHint("Market Location");
        consulting_Dr.setVisibility(GONE);

        String[] no = new String[] {"1", "2"};
        String[] hospitals=new String[] {"Dmart","Parth General Store","Dhruvi Suoer Market"};



        ArrayAdapter<String> adapter_accompany =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        no);

        ArrayAdapter<String> adapter_hospital =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        hospitals);


//        ArrayAdapter<String> adapter_sub =
//                new ArrayAdapter<>(
//                        this,
//                        R.layout.dropdown_menu_popup_item,
//                        BookFragment.getSubject_names_clone());

        AutoCompleteTextView editTextFilledExposedDropdown1 =
                findViewById(R.id.number_of_memb);
        editTextFilledExposedDropdown1.setAdapter(adapter_accompany);



        AutoCompleteTextView editTextFilledExposedDropdown2 =
                findViewById(R.id.dest);
        editTextFilledExposedDropdown2.setAdapter(adapter_hospital);

    }


    private void initialize_spinners_medical() {

        destination.setHint("Nearby Hospital");
        destin_add.setHint("Hospital Location");

        consulting_Dr.setVisibility(View.VISIBLE);



        String[] no = new String[] {"1", "2"};
        String[] hospitals=new String[] {"Nanavati Hospital","Bombay Hospital & Medical Research Centre","Hinduja National Hospital","Hiranandani Hospital","Kalsubai Hospital"};



        ArrayAdapter<String> adapter_accompany =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        no);

        ArrayAdapter<String> adapter_hospital =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        hospitals);



        AutoCompleteTextView editTextFilledExposedDropdown1 =
                findViewById(R.id.number_of_memb);
        editTextFilledExposedDropdown1.setAdapter(adapter_accompany);



        AutoCompleteTextView editTextFilledExposedDropdown2 =
                findViewById(R.id.dest);
        editTextFilledExposedDropdown2.setAdapter(adapter_hospital);


    }

    public void qrcode(View view) {
        if(check_validity())
        {




            qr_code_generate(chiptype,destination.getText().toString(),destin_add.getText().toString(),date.getText().toString(),time.getText().toString(),"Unverified","None");
            progress.setTitle("Request");
            progress.setMessage("Please wait while your request is being verified by the authorities");

        }




    }

    private void qr_code_generate(String chip,String dest, String dest_add, String date, String time,String status, String VerifiedBy) {

        ImageView qrimg = findViewById(R.id.qrgenerate);

            String inputValue="Name: "+account_name+"\n"+"Reason: " +chip+"\n"+"Destination: "+dest+"\n"+"Location: "+dest_add+"\n"+"On:  "+date+" \n"+"At: "+time+" \n"+"Status: "+status +"\n"+"Verified By: "+VerifiedBy+" \n"+"Total Accompanies: 1 \n";

        if (inputValue.length() > 0) {
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension ;


            QRGEncoder qrgEncoder = new QRGEncoder(inputValue, null, QRGContents.Type.TEXT, smallerDimension);
            //Unverified

            ImageView status_=findViewById(R.id.verification_badge);

            if(status.equals("Verified"))
            {
                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 5000);
                status_.setVisibility(View.VISIBLE);

                status_.setImageResource(R.drawable.correct);
                qrgEncoder.setColorBlack(Color.BLUE);
                qrgEncoder.setColorWhite(Color.WHITE);
            }
            else {

                status_.setVisibility(View.VISIBLE);

                status_.setImageResource(R.drawable.warning);
                qrgEncoder.setColorBlack(Color.BLACK);
                qrgEncoder.setColorWhite(Color.WHITE);
            }
            try {
                // Getting QR-Code as Bitmap
                Bitmap bitmap = qrgEncoder.getBitmap();
                // Setting Bitmap to ImageView
                qrimg.setImageBitmap(bitmap);

                Button verify=findViewById(R.id.verify);
                verify.setVisibility(View.VISIBLE);


            } catch (Exception e) {
                Log.v("QR ERROR", e.toString());
            }
        }


    }

    private boolean check_validity() {

        if (destination.getText().toString().isEmpty()|| destin_add.getText().toString().isEmpty() || date.getText().toString().isEmpty() || time.getText().toString().isEmpty() )
        {
            //Toast.makeText(this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
            return false;
        }

return  true;

    }



    public void date(View view) {

        date.setKeyListener(null);

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void time(View view) {


        time.setKeyListener(null);
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        time.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();

    }


    public void verify(View view) {

        progress.show();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "GO CORONA";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_MAX);
            // Configure the notification channel.
            notificationChannel.setDescription("Sample Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("GO CORONA")
                //.setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("QR Code Verified")
                .setContentText("Your travel pass to Nanavati has been verified by Dr. Paras")
                .setContentInfo("Information");
        notificationManager.notify(1, notificationBuilder.build());

        qr_code_generate(chiptype,destination.getText().toString(),destin_add.getText().toString(),date.getText().toString(),time.getText().toString(),"Verified","Dr. Paras");
    }

//    public void verify(View view) {
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(GO_OUT.this)
//                        .setSmallIcon(R.drawable.woman)
//                        .setContentTitle("Notifications Example")
//                        .setContentText("This is a test notification");
//
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(GO_OUT.this, 0, notificationIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(contentIntent);
//
//        // Add as notification
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        assert manager != null;
//        manager.notify(0, builder.build());
//    }
}


