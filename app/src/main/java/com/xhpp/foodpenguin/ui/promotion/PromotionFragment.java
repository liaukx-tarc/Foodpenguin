package com.xhpp.foodpenguin.ui.promotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.main.RestaurantAdapter;

import java.util.ArrayList;

public class PromotionFragment extends Fragment {

    ListView list;
    ArrayList <Promotion> promotion = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        list = view.findViewById(R.id.listViewPromotion);

        final ArrayList <Promotion> promotion = new ArrayList<>();
        promotion.add(new Promotion(R.drawable.promotion1,"Mcdonalds Promotion","Free one McChicken burger"));
        promotion.add(new Promotion(R.drawable.promotion2,"KFC Promotion","Free one medium fries"));
        promotion.add(new Promotion(R.drawable.promotion3,"Burger King Promotion","Free one chicken burger"));
        promotion.add(new Promotion(R.drawable.promotion4,"Domino's Pizza Promotion","Free small size pizza"));
        promotion.add(new Promotion(R.drawable.promotion5,"A&W Promotion","Free one regular size hotdog bun"));
        promotion.add(new Promotion(R.drawable.promotion6,"Pizza Hut Promotion","Free one more set of mushroom soup and garlic bread"));
        promotion.add(new Promotion(R.drawable.promotion7,"Wendy's Promotion","Free one Cheesy Cheddarburger"));

        final PromotionAdapter promotionAdapter = new PromotionAdapter(getContext(),R.layout.promotion_row,promotion);
        list.setAdapter(new PromotionAdapter(getContext(),R.layout.promotion_row,promotion));

        return view;
    }
}