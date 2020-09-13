package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.xhpp.foodpenguin.R;

import java.util.ArrayList;


public class MainFragment extends Fragment
{
    SearchView mySearchView;
    ListView myList;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        mySearchView = view.findViewById(R.id.searchView);
        myList = view.findViewById(R.id.listView);


        ArrayList <Restaurant> arrayList= new ArrayList<>();

        arrayList.add(new Restaurant(R.drawable.mcd,"McDonalds", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.kfc,"KFC", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.burgerking,"Burger King", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.domino,"Domino's Pizza", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.aandw,"A&W", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.wendy,"Wendy's", "Fast Food"));

        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(),R.layout.list_row,arrayList);
        myList.setAdapter(restaurantAdapter);

//        List<String> list = new ArrayList<>();
//        list.add("McDonalds");
//        list.add("KFC");
//        list.add("Burger King");
//        list.add("Pizza Hut");
//        list.add("Domino's Pizza");
//        list.add("A&W");
//        list.add("Wendy's");
//
//
//
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
//        myList.setAdapter(adapter);


        //searchBar
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                restaurantAdapter.getFilter().filter(s);
                return false;
            }
        });

         return view ;
    }

}