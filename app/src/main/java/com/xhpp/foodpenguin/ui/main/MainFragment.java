package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.food_menu.mcd;
import java.util.ArrayList;

public class MainFragment extends Fragment implements  View.OnClickListener,ItemClickListener{

    ArrayList<Restaurant> arrayList;
    private RecyclerView mRecyclerView;
    private RestaurantAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    TextInputLayout textInputLayout;
    Button button;
    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);


        createList();
        mRecyclerView = view.findViewById(R.id.recycleView);
        textInputLayout = view.findViewById(R.id.search);
        button = view.findViewById(R.id.searchButton);
        button.setOnClickListener(this);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RestaurantAdapter(arrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        recyclerView = view.findViewById(R.id.recycleView);
        restaurantAdapter = new RestaurantAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(restaurantAdapter);
        restaurantAdapter.setClickListener(this);



        return view;
    }

    @Override
    public void onClick(View view, int position) {
        String name = arrayList.get(position).getText1();
        Toast.makeText(getActivity(),"Helo",Toast.LENGTH_SHORT).show();
        if(name == "mcd") {
            Fragment fragment = new Fragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout, fragment);
            fragmentTransaction.commit();

        }

    }


    private void createList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Restaurant(R.drawable.mcd, "McDonalds", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.kfc, "KFC", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.domino, "Domino's Pizza", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.burgerking, "Burger King", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.aandw, "A&W", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.pizzahut, "Pizza Hut", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.wendy, "Wendy's", "Fast Food"));
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch(view.getId())
        {
            case R.id.searchButton:
                String text = textInputLayout.getEditText().getText().toString();
                mAdapter.getFilter().filter(text);
                break;
        }
    }


}



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


