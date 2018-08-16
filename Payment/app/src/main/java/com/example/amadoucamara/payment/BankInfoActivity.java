package com.example.amadoucamara.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class BankInfoActivity extends AppCompatActivity {

    private LinearLayout llAddBank;
    private LinearLayout llAddCard;

    private EditText etAccount;
    private EditText etConfirm;

    private List <EditText> accountFields;
    private List <EditText> cardFields;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_info);

        llAddBank = (LinearLayout) findViewById(R.id.llAddBank);
        llAddCard = (LinearLayout) findViewById(R.id.llAddCard);

        EditText etRouting = (EditText) findViewById(R.id.etRouting);
        etAccount = (EditText) findViewById(R.id.etAccount);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        accountFields = Arrays.asList(etRouting, etAccount, etConfirm);


        EditText etCard = (EditText) findViewById(R.id.etCard);
        EditText etExpiration = (EditText) findViewById(R.id.etExpiration);
        EditText etSecurity = (EditText) findViewById(R.id.etSecurity);
        EditText etZipCode = (EditText) findViewById(R.id.etZipCode);
        cardFields = Arrays.asList(etCard, etExpiration, etSecurity, etZipCode);
    }

    public void displayBankInfo(View view) {
        llAddCard.setVisibility(View.INVISIBLE);
        llAddBank.setVisibility(View.VISIBLE);
    }

    public void displayCardInfo(View view) {
        llAddBank.setVisibility(View.INVISIBLE);
        llAddCard.setVisibility(View.VISIBLE);
    }

    public void submitBank(View view) {
        Boolean allComplete = true;
        Boolean accountNumbersMatch = true;
        for (EditText field : accountFields) {
            if (field.getText().toString().equals("")) {
                field.setText(null);
                field.setHintTextColor(getResources().getColor(R.color.alertRed));
                allComplete = false;
                Toast.makeText(BankInfoActivity.this,
                        "Higlighted fields are incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (!etAccount.getText().toString().equals(etConfirm.getText().toString())) {
            accountNumbersMatch = false;

            etAccount.setText(null);
            etConfirm.setText(null);

            etConfirm.setHintTextColor(getResources().getColor(R.color.alertRed));
            etAccount.setHintTextColor(getResources().getColor(R.color.alertRed));

            etConfirm.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    etConfirm.setHintTextColor(getResources().getColor(R.color.hintGray));
                    etAccount.setHintTextColor(getResources().getColor(R.color.hintGray));
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            Toast.makeText(BankInfoActivity.this,
                    "Account numbers don't match", Toast.LENGTH_SHORT).show();
        }

        if (accountNumbersMatch && allComplete) {
            Intent intent = new Intent(this, ServicesActivity.class);
            this.startActivity(intent);
        }
    }

    public void submitCard(View view) {
        Boolean allComplete = true;
        for (EditText field : cardFields) {
            if (field.getText().toString().equals("")) {
                field.setText(null);
                field.setHintTextColor(getResources().getColor(R.color.alertRed));
                allComplete = false;
                Toast.makeText(BankInfoActivity.this,
                        "Higlighted fields are incorrect", Toast.LENGTH_SHORT).show();
            }
        }

        if (allComplete) {
            Intent intent = new Intent(this, ServicesActivity.class);
            this.startActivity(intent);
        }
    }
}
