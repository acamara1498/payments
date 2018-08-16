package com.example.amadoucamara.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etDOB;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirm;
    private EditText etPhone;
    private List<EditText> fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDOB = findViewById(R.id.etDOB);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        etPhone = findViewById(R.id.etPhone);

        fields = Arrays.asList(etFirstName, etLastName, etDOB, etEmail, etPassword, etConfirm, etPhone);

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
            Intent intent = new Intent(this, BankInfoActivity.class);
            intent.putExtra("first_name", etFirstName.getText().toString());
            intent.putExtra("last_name", etLastName.getText().toString());
            intent.putExtra("date_of_birth", etDOB.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());
            intent.putExtra("password", etPassword.getText().toString());
            intent.putExtra("phone", etPhone.getText().toString());
            this.startActivity(intent);
        }
    }
}
