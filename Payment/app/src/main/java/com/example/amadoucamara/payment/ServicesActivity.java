package com.example.amadoucamara.payment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amadoucamara.payment.adapters.ServicesAdapter;
import com.example.amadoucamara.payment.models.Services;

import java.util.List;

import static com.example.amadoucamara.payment.models.User.getCurrentUser;

public class ServicesActivity extends AppCompatActivity {

    private RecyclerView rvServices;
    private List<Services> services;
    private ServicesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvWelcome.setText(String.format("Welcome, %s! \n Your balance is:",getCurrentUser().getFirstName()));


        rvServices = findViewById(R.id.rvServices);
        rvServices.setHasFixedSize(true);
        final GridLayoutManager layout = new GridLayoutManager(ServicesActivity.this, 2);

        // Unlike ListView, you have to explicitly give a LayoutManager to the RecyclerView to position items on the screen.
        // There are three LayoutManager provided at the moment: GridLayoutManager, StaggeredGridLayoutManager and LinearLayoutManager.
        rvServices.setLayoutManager(layout);

        // get data
        services = Services.getTypes();

        // Create an adapter
        adapter = new ServicesAdapter(ServicesActivity.this, services);

        // Bind adapter to list
        rvServices.setAdapter(adapter);

    }

    public void transferToBank(View view) {
        Toast.makeText(this, "TRANSFER", Toast.LENGTH_SHORT).show();
    }
}
