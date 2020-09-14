package com.xhpp.foodpenguin.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    ImageButton curUpButton;
    ImageButton curDownButton;
    ImageButton recUpButton;
    ImageButton recDownButton;
    ImageButton backButton;
    CardView currentOrderContainer;
    RecyclerView recentOrderDetail;
    OrderAdapter orderAdapter;
    List<Order> orderList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_order,container,false);

        backButton = view.findViewById(R.id.backButton);
        curUpButton = view.findViewById(R.id.upButton);
        curDownButton = view.findViewById(R.id.downButton);
        recUpButton = view.findViewById(R.id.upButtonRecent);
        recDownButton = view.findViewById(R.id.downButtonRecent);

        backButton.setOnClickListener(pListener);
        curUpButton.setOnClickListener(pListener);
        curDownButton.setOnClickListener(pListener);
        recUpButton.setOnClickListener(pListener);
        recDownButton.setOnClickListener(pListener);

        currentOrderContainer = view.findViewById(R.id.currentOrderContainer);
        currentOrderContainer.setVisibility(View.GONE);
        recentOrderDetail = view.findViewById(R.id.recentOrderDetail);
        recentOrderDetail.setVisibility(View.GONE);

        orderAdapter = new OrderAdapter(orderList,this.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);
        recentOrderDetail.setLayoutManager((layoutManager));
        recentOrderDetail.setItemAnimator(new DefaultItemAnimator());
        recentOrderDetail.setAdapter((orderAdapter));

        for(int i = 0; i < 2; i++)
        {
            Order order = new Order("1234","OD012","KFC","12/9/2020",20.00);
            orderList.add(order);
        }

        return view;
    }

    private final View.OnClickListener pListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.backButton:
                    getFragmentManager().popBackStackImmediate();
                    break;
                case R.id.upButton:
                    curUpButton.setVisibility(View.GONE);
                    curDownButton.setVisibility(View.VISIBLE);
                    currentOrderContainer.setVisibility(View.GONE);
                    break;
                case R.id.downButton:
                    curUpButton.setVisibility(View.VISIBLE);
                    curDownButton.setVisibility(View.GONE);
                    currentOrderContainer.setVisibility(View.VISIBLE);
                    break;
                case R.id.upButtonRecent:
                    recUpButton.setVisibility(View.GONE);
                    recDownButton.setVisibility(View.VISIBLE);
                    recentOrderDetail.setVisibility(View.GONE);
                    break;
                case R.id.downButtonRecent:
                    recUpButton.setVisibility(View.VISIBLE);
                    recDownButton.setVisibility(View.GONE);
                    recentOrderDetail.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

}




