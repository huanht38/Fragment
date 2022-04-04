package com.example.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;


public class ListFragment extends androidx.fragment.app.ListFragment {

    private ArrayList<Product> products;

    CustomAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list, container, false);
        products= new ArrayList<>();
        products.add(new Product(1,"Nike shoes-discount 50%",100));
        products.add(new Product(2,"Adidas shoes-discount 80%",100));
        products.add(new Product(3,"Nike Bicycle-discount 30%",100));
        products.add(new Product(4,"Nike Bicycle-discount 30%",100));
        products.add(new Product(5,"Victor shoes-discount 50%",100));
        products.add(new Product(6,"Lining shoes-discount 50%",100));
        products.add(new Product(7,"Binh Minh shoes-discount 90%",100));
        products.add(new Product(8,"Nike shoes-discount 50%",100));
        products.add(new Product(9,"Adidas shoes-discount 80%",100));
        products.add(new Product(10,"Nike Bicycle-discount 30%",100));
        products.add(new Product(11,"Nike Bicycle-discount 30%",100));
        products.add(new Product(12,"Victor shoes-discount 50%",100));
        adapter = new CustomAdapter(getActivity(), R.layout.custom_listproduct, products);
        setListAdapter(adapter);
        return view;
    }





    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        final Product product= products.get(position);

        int oreint= getResources().getConfiguration().orientation;

        if (oreint== Configuration.ORIENTATION_PORTRAIT){
            openSecondActivity(product);

        }else{
            landLayout(product);

        }
    }

    private void landLayout(Product product) {
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        DetailFragment detailFragment= (DetailFragment) fragmentManager.findFragmentById(R.id.fragmentDetail);
        detailFragment.loadData(product);

    }

    private void openSecondActivity(Product product) {
        //Toast.makeText(getContext(),product.getName(),Toast.LENGTH_LONG).show();
        Intent intent= new Intent(getActivity(),SecondActivity.class);
        Bundle bundle  = new Bundle();
        bundle.putSerializable("product", product);
        intent.putExtra("data", bundle);
        startActivity(intent);


    }


}