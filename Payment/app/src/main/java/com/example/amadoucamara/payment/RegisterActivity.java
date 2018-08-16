package com.example.amadoucamara.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amadoucamara.payment.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etUsername;
    private EditText etDOB;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirm;
    private EditText etPhone;
    private List<EditText> fields;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etDOB = findViewById(R.id.etDOB);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        etPhone = findViewById(R.id.etPhone);

        fields = Arrays.asList(etFirstName, etLastName, etUsername,
                etDOB, etEmail, etPassword, etConfirm, etPhone);

        auth = FirebaseAuth.getInstance();

    }

    public void toBankInfo(View view) {
        Boolean allComplete = true;
        Boolean passwordsMatch = true;

        for (EditText field : fields) {
            if (field.getText().toString().equals("")) {
                field.setText(null);
                field.setHintTextColor(getResources().getColor(R.color.alertRed));
                allComplete = false;
                Toast.makeText(RegisterActivity.this,
                        "Higlighted fields are incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (!etPassword.getText().toString().equals(etConfirm.getText().toString())) {
            passwordsMatch = false;

            etPassword.setText(null);
            etConfirm.setText(null);

            etConfirm.setHintTextColor(getResources().getColor(R.color.alertRed));
            etPassword.setHintTextColor(getResources().getColor(R.color.alertRed));

            etConfirm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    etConfirm.setHintTextColor(getResources().getColor(R.color.hintGray));
                    etPassword.setHintTextColor(getResources().getColor(R.color.hintGray));
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            Toast.makeText(RegisterActivity.this,
                    "Passwords don't match", Toast.LENGTH_SHORT).show();
        }

        if (allComplete && passwordsMatch) {
            Intent intent = new Intent(RegisterActivity.this, BankInfoActivity.class);
            User user = new User(etFirstName.getText().toString(), etLastName.getText().toString()
                    , etUsername.getText().toString(), etDOB.getText().toString(),
                    etPhone.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());

            auth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = auth.getCurrentUser();
                                Intent intent = new Intent(RegisterActivity.this, BankInfoActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }
}
