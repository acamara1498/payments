package com.example.amadoucamara.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class BankInfoActivity extends AppCompatActivity {

    private LinearLayout llAddBank;
    private LinearLayout llAddCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_info);

        llAddBank = (LinearLayout) findViewById(R.id.llAddBank);
        llAddCard = (LinearLayout) findViewById(R.id.llAddCard);
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
        Intent intent = new Intent(this, ServicesActivity.class);
        this.startActivity(intent);
    }

    public void submitCard(View view) {
        Intent intent = new Intent(this, ServicesActivity.class);
        this.startActivity(intent);
    }
}
