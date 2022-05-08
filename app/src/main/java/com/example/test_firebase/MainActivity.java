package com.example.test_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        EditText txtEmail = findViewById(R.id.txtEmail);
        Editable email = txtEmail.getText();
        EditText txtPass = findViewById(R.id.txtPass);
        Editable pass = txtPass.getText();
        Button btnsignin = findViewById(R.id.btnsignin);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, email.toString(), Toast.LENGTH_LONG).show();
                auth.signInWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "dang nhap thanh cong", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this,Request.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "dang nhap khong thanh cong", Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });


    }
}