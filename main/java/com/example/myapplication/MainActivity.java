package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.example.myapplication.Adapter.PersonAdapter;
import com.example.myapplication.ViewModel.personModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView personRecycler;
    public static FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    public static List<personModel> personModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personRecycler = findViewById(R.id.person_recycler);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        personRecycler.setLayoutManager(layoutManager);

        personModelList.clear();
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseFirestore.collection("userdata").
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                        // List<personModel> personModelList=new ArrayList<>();
                        long no_of_user = (long) documentSnapshot.get("no_of_user");
                        for (long x = 1; x < no_of_user + 1; x++) {
                            personModelList.add(new personModel(documentSnapshot.get("name_"+ x).toString(),
                                    documentSnapshot.get("city_" + x).toString(),
                                    documentSnapshot.get("phone_" + x).toString(),
                                    documentSnapshot.get("gender_" + x).toString(),
                                    documentSnapshot.get("userid_" + x).toString()));

                        }

                       }
                    PersonAdapter personAdapter=new PersonAdapter(personModelList);
                    personRecycler.setAdapter(personAdapter);
                    personAdapter.notifyDataSetChanged();
                }
            }
        });






    }
}
