package com.xhpp.foodpenguin.ui.food_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xhpp.foodpenguin.R;

import java.util.ArrayList;

public class FoodInfoActivity extends AppCompatActivity {

    ListView mcdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcd_menu);

        mcdList = findViewById(R.id.mcdfood);


//        ArrayList<Mcdonals> foodlist = new ArrayList<>();
//
//        foodlist.add();


    }
}

