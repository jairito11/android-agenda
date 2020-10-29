package com.jairo.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

enum ProviderType {
    BASIC
}

public class HomeActivity extends AppCompatActivity {
    TextView tvemail,tvprovider;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvemail = (TextView) findViewById(R.id.tvEmail);
        tvprovider = (TextView)findViewById(R.id.tvProvider);

        btnLogout = findViewById(R.id.btnLogout);

        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("email");
        String provider = bundle.getString("provider");

        setup(email,provider);
    }

    private void setup(String email, String provider) {
        this.setTitle("Inicio");
        tvemail.setText(email);
        tvprovider.setText(provider.toString());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                onBackPressed();
            }
        });
    }
}