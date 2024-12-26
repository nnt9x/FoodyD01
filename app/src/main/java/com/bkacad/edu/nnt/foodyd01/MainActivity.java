package com.bkacad.edu.nnt.foodyd01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Khai bao view
    private EditText edtSearch;
    private ListView lvFood;

    // Adapter
    private FoodAdapter foodAdapter;
    private List<Food> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind id
        edtSearch = findViewById(R.id.edt_search);
        lvFood = findViewById(R.id.lv_food);
        // Chuan bi du lieu
        data = new ArrayList<>();
        data.add(new Food("Bún bò Huế 1", 35000,"","https://images.freeimages.com/images/large-previews/ebc/joyful-white-dog-in-nature-0410-5697280.jpg?fmt=webp&w=500" ));
        data.add(new Food("Bún bò Huế 2", 36000,"","https://29foods.com/media/news/408_bun_bo_gio_heo.jpg" ));
        data.add(new Food("Bún bò Huế 3", 37000,"","https://29foods.com/media/news/408_bun_bo_gio_heo.jpg" ));
        // Set Adapter
        foodAdapter = new FoodAdapter(this, data);
        lvFood.setAdapter(foodAdapter);

        // Bat su kien Click vao tung Itemview
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lay du lieu
                Food food = data.get(position);
                // Truyen du lieu sang man hinh 2 -> thong qua intent
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                // Them du lieu
                i.putExtra("FOOD_NAME", food.getName());
                i.putExtra("FOOD_PRICE", food.getPrice());
                i.putExtra("FOOD_IMAGE", food.getImage());
                i.putExtra("FOOD_DESCRIPTION", food.getDescription());
                // Start Activity
                startActivity(i);
            }
        });


    }
}