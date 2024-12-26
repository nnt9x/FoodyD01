package com.bkacad.edu.nnt.foodyd01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private TextView tvFoodName;
    private ImageView imgFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Lay du lieu tu MainActivity gui sang
        Intent intent = getIntent();
        String name = intent.getStringExtra("FOOD_NAME");
        int price = intent.getIntExtra("FOOD_PRICE",0);
        String image = intent.getStringExtra("FOOD_IMAGE");
        String description = intent.getStringExtra("FOOD_DESCRIPTION");

        // Bind id
        imgFood = findViewById(R.id.second_img_food_image);
        tvFoodName = findViewById(R.id.second_tv_food_name);
        // Do du lieu
        tvFoodName.setText(name);
        Picasso.get().load(image).into(imgFood);

    }
}