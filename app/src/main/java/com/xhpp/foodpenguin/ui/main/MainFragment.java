package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.food_menu.ItemFragment;


import java.util.ArrayList;

public class MainFragment extends Fragment {
    SearchView mySearchView;
    private ArrayList<Restaurant> arrayList;
    private RecyclerView mRecyclerView;
    private RestaurantAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mySearchView = view.findViewById(R.id.searchView);
//        myList = view.findViewById(R.id.listView);


        createList();
        mRecyclerView = view.findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RestaurantAdapter(arrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter((mAdapter));
        mAdapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ItemFragment itemFragment = new ItemFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(),itemFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
//                arrayList.get(position);

//                if(position == 1)
//                {
//
//                }
            }
        });
        return view;
    }


    private void createList() {
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        arrayList.add(new Restaurant(R.drawable.mcd, "McDonalds", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.kfc, "KFC", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.burgerking, "Burger King", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.domino, "Domino's Pizza", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.aandw, "A&W", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.pizzahut, "Pizza Hut", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.wendy, "Wendy's", "Fast Food"));
    }
}

//        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(), R.layout.list_row, arrayList);
//        myList.setAdapter(new RestaurantAdapter(getContext(), R.layout.list_row, arrayList));



//    @Override
//    public void onClick(View view) {
//        switch(view.getId()) {
//            case R.id.mcdfood:
//            ItemFragment itemFragment = new ItemFragment();
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(((ViewGroup) getView().getParent()).getId(), itemFragment);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
//        }


