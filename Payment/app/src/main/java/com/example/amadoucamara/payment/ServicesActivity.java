package com.example.amadoucamara.payment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amadoucamara.payment.adapters.ServicesAdapter;
import com.example.amadoucamara.payment.models.Services;

import java.util.List;

public class ServicesActivity extends AppCompatActivity {

    private RecyclerView rvServices;
    private List<Services> services;
    private ServicesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        rvServices = (RecyclerView) findViewById(R.id.rvServices);
        rvServices.setHasFixedSize(true);
        final GridLayoutManager layout = new GridLayoutManager(ServicesActivity.this, 1);

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
}
