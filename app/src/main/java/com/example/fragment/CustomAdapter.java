package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Product> {
    private Context context;
    private  int resource;
    private int idImage;
    private ArrayList<Product> products;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product>products) {
        super(context, resource, products);
        this.context= context;
        this.resource= resource;
        this.products= products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
            convertView= LayoutInflater.from(context).inflate(R.layout.custom_listproduct, parent,false);

        TextView tv_name= (TextView) convertView.findViewById(R.id.textView_name);
        tv_name.setText(products.get(position).getName());
        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView_item);
        idImage= products.get(position).getId();

        switch (idImage){
            case 1:imageView.setImageResource(R.drawable.img);
                break;
            case 2:imageView.setImageResource(R.drawable.img_1);
                break;
            case 3:imageView.setImageResource(R.drawable.img_2);
                break;
            case 4:imageView.setImageResource(R.drawable.img_3);
                break;
            case 5:imageView.setImageResource(R.drawable.img_4);
                break;
            case 6:imageView.setImageResource(R.drawable.img_5);
                break;
            case 7:imageView.setImageResource(R.drawable.img_6);
                break;
            case 8:imageView.setImageResource(R.drawable.img);
                break;
            case 9:imageView.setImageResource(R.drawable.img_1);
                break;
            case 10:imageView.setImageResource(R.drawable.img_2);
                break;
            case 11:imageView.setImageResource(R.drawable.img_3);
                break;
            case 12:imageView.setImageResource(R.drawable.img_4);
                break;
            default:break;

        }

        return convertView;
    }
}
