package com.bkacad.edu.nnt.foodyd01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    // Thuoc tinh
    private Context context;
    private List<Food> data;

    // Phuong thuc khoi tao
    public FoodAdapter(Context context, List<Food> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        }
        // Khai bao view - ItemView
        ImageView imgFood = convertView.findViewById(R.id.item_food_image);
        TextView tvFoodName = convertView.findViewById(R.id.item_food_name);
        TextView tvFoodPrice = convertView.findViewById(R.id.item_food_price);
        // Do du lieu vao view
        // Du lieu position -> ung voi view o vi tri position
        Food food = data.get(position);
        tvFoodPrice.setText("" + food.getPrice());
        tvFoodName.setText(food.getName());
        Picasso.get().load(food.getImage()).into(imgFood);

        return convertView;
    }
}
