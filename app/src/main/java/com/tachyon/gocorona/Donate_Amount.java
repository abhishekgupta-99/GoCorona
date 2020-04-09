package com.tachyon.gocorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.tachyon.gocorona.adapters.Donate_Adapter;
import com.tachyon.gocorona.models.Donate_ngo_model;

import java.util.ArrayList;
import java.util.Objects;

public class Donate_Amount extends AppCompatActivity {

    private Donate_Adapter donate_adap;
    private RecyclerView rvdonate;
    private FirebaseFirestore db;
    private ArrayList<Donate_ngo_model> ngos=new ArrayList<Donate_ngo_model>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate__amount);
        rvdonate=findViewById(R.id.ngo_donate);

        db = FirebaseFirestore.getInstance();
        final int[] count = {0};



        db.collection("Donation_NGO").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        count[0]++;

                        Log.d("Document",document.getId());


                        Donate_ngo_model ngo = document.toObject(Donate_ngo_model.class);
                       // Toast.makeText(Donate_Amount.this, ngo.description, Toast.LENGTH_SHORT).show();
                        ngos.add(ngo);
                    }

                }
            }
        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                if(count[0]==ngos.size())
                {
                    donate_adap = new Donate_Adapter(getApplicationContext(),ngos);
                    LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                    rvdonate.setLayoutManager(manager);

                    rvdonate.setAdapter(donate_adap);
                }

            }
        });

    }
}
