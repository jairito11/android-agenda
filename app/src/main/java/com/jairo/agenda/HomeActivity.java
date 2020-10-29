package com.jairo.agenda;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

enum ProviderType {
    BASIC
}

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
    }
}