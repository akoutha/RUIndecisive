package com.example.ruindecisive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.*;

import com.example.ruindecisive.model.Restaurant;

public class RestaurantAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Restaurant> restaurants;
    private static LayoutInflater inflater = null;

    public RestaurantAdapter(Activity context, ArrayList<Restaurant> restaurants){
        this.context = context;
        this.restaurants = restaurants;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item,null): itemView;
        TextView textViewName  = (TextView) itemView.findViewById(R.id.textView_name);
        TextView textViewType  = (TextView) itemView.findViewById(R.id.textView_type);
        Restaurant restaurant = restaurants.get(position);
        textViewName.setText(restaurant.getName());
        textViewType.setText((restaurant.getType()));
        return itemView;

    }

    @Override
    public int getCount() {
        return restaurants.size();
    }
}
