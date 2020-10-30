package com.jairo.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CitaActivity extends AppCompatActivity {

    TextView fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        this.setTitle("Confirmar Cita");
        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        fecha = findViewById(R.id.tvFecha);
        fecha.setText(date);
    }
}