package com.example.consultant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class registration_page extends AppCompatActivity {
    EditText u_email, u_pass, u_cpass;
    Button reg;
    private FirebaseAuth auth;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        u_email = findViewById(R.id.u_email);
        u_pass = findViewById(R.id.u_pass);
        u_cpass = findViewById(R.id.u_cpass);
        reg = findViewById(R.id.reg);
        radioGroup = findViewById(R.id.radio_group_gender);
        auth = FirebaseAuth.getInstance();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_button_male) {
                    Toast.makeText(registration_page.this, "Male selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio_button_female) {
                    Toast.makeText(registration_page.this, "Female selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reg.setOnClickListener(view ->
        {
            if (u_pass.getText().toString().equals(u_cpass.getText().toString()))
            {
                if (u_email.getText().toString().isEmpty() || u_pass.getText().toString().isEmpty())
                {
                    Toast.makeText(registration_page.this, "Fill the required Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String email = u_email.getText().toString();
                    String password = u_pass.getText().toString();
                    //Registeration Code
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(registration_page.this, task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(registration_page.this, "register successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(registration_page.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                Toast.makeText(getApplicationContext(), "Passwords match", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

    }

}












