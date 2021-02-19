package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class PersonDetailActivity extends AppCompatActivity {

    public TextView showname1,showcity1,showphone1,showgender1;
    public FirebaseFirestore firebaseFirestore;
    public String personid;
    private DocumentSnapshot documentSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        showname1 = findViewById(R.id.showname);
        showcity1 = findViewById(R.id.showcity);
        showphone1 = findViewById(R.id.showphone);
        showgender1 = findViewById(R.id.showgender);


        firebaseFirestore= FirebaseFirestore.getInstance();
        final List<String> productImage=new ArrayList<>();
        personid  = getIntent().getStringExtra("personId");

        firebaseFirestore.collection("users").document(personid).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            documentSnapshot = task.getResult();
                            showname1.setText(documentSnapshot.get("name").toString());
                            showcity1.setText(documentSnapshot.get("city").toString());
                            showphone1.setText(documentSnapshot.get("phone").toString());
                            showgender1.setText(documentSnapshot.get("gender").toString());
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(PersonDetailActivity.this, error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
