//package com.xhpp.foodpenguin.ui.main;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.media.Image;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.xhpp.foodpenguin.R;
//
//public class RestaurantMenu extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurant_menu);
//
//        Intent intent = getIntent();
//        Restaurant restaurant = intent.getParcelableExtra("Example item");
//
//        int imageRes = restaurant.getImage();
//        String line1 = restaurant.getName();
//        String line2 = restaurant.getDesc();
//
//        ImageView imageView = findViewById(R.id.imageForMenu);
//        imageView.setImageResource(imageRes);
//
//        TextView textView1 = findViewById(R.id.textForFoodMenu1);
//        textView1.setText(line1);
//
//        TextView textView2 = findViewById(R.id.textForFoodMenu2);
//        textView2.setText(line2);
//    }
//}