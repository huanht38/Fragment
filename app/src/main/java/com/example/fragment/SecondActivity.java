package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent= getIntent();
        Bundle bundle= intent.getBundleExtra("data");
        Product product=(Product) bundle.getSerializable("product");
        FragmentManager fragmentManager= getSupportFragmentManager();
        DetailFragment detailFragment= (DetailFragment) fragmentManager.findFragmentById(R.id.fragmentDetail);
        if(detailFragment!=null && detailFragment.isAdded())
            detailFragment.loadData(product);
    }
}