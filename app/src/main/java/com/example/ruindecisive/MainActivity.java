package com.example.ruindecisive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import com.example.ruindecisive.model.Restaurant;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "restaurant.name";
    ListView list;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    RestaurantAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateList();
        Button button = (Button) findViewById(R.id.pick_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) Math.floor(Math.random()*restaurants.size());
                Restaurant restaurant = restaurants.get(random);
                String name = restaurant.getName();
                //  Toast.makeText(this,"you have chosen "+name,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                intent.putExtra(EXTRA_NAME,name);
                MainActivity.this.startActivity(intent);

            }
        });





    }

    public void populateList(){
        list = (ListView) findViewById(R.id.restaurant_lv);
        restaurants.add(new Restaurant("daniels","pizza"));
        restaurants.add(new Restaurant("Tacoria","Mexican"));
        restaurants.add(new Restaurant("Mamouns","Mediterrean"));
        restaurants.add(new Restaurant("barca","spanish"));
        restaurants.add(new Restaurant("Subway","American"));
        restaurants.add(new Restaurant("Evelyns","Mediterrean"));
        restaurants.add(new Restaurant("Chipotle","Mexican"));
        restaurants.add(new Restaurant("La Catrina","Mexican"));
        restaurants.add(new Restaurant("King of Gyro","Mediterrean"));

        adapter = new RestaurantAdapter(this, restaurants);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click to item "+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
