package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class register_activity extends AppCompatActivity {

    private FrameLayout framelayout;
    public static boolean setSignupFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);


        framelayout=findViewById(R.id.register_framelayout);

        if(setSignupFragment) {
            setSignupFragment=false;
            setFragment(new SignUpFragment());
        }else{
            setFragment(new SignInFragment());
        }


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(framelayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}

