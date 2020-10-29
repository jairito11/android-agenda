package com.jairo.agenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button btnRegistrar,btnLogin;
    EditText etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnLogin = findViewById(R.id.btnLogin);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //Mando la información a Analytics
        Bundle params = new Bundle();
        params.putString("message","Integración de Firebase completa");
        mFirebaseAnalytics.logEvent("IniciaHome",params);

        //setup
        setup();
    }

    private void setup() {
        this.setTitle("Autenticación");
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //etEmail.getText().toString().isEmpty()
                if ((!etEmail.getText().toString().isEmpty() && etEmail.getText().toString().contains("@"))&& !etPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Conectando", Toast.LENGTH_SHORT).show();

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){

                                    }else{
                                        Toast.makeText(MainActivity.this, "Error en la autenticación", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }else{
                    Toast.makeText(MainActivity.this, "Utiliza un formato correcto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}