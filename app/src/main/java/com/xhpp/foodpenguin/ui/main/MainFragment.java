package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList <Restaurant> arrayList= new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        mySearchView = view.findViewById(R.id.searchView);
        myList = view.findViewById(R.id.listView);


        final ArrayList <Restaurant> arrayList= new ArrayList<>();

        arrayList.add(new Restaurant(R.drawable.mcd,"McDonalds", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.kfc,"KFC", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.burgerking,"Burger King", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.domino,"Domino's Pizza", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.aandw,"A&W", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.pizzahut,"Pizza Hut", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.wendy,"Wendy's", "Fast Food"));

        final RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(),R.layout.list_row,arrayList);
        myList.setAdapter(new RestaurantAdapter(getContext(),R.layout.list_row,arrayList));


         return view ;
    }

    //searchbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        setHasOptionsMenu(true);
        inflater.inflate(R.menu.search_bar, menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
            //searchBar
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList <Restaurant> results=new ArrayList<>();
                for(Restaurant x: arrayList)
                {
                    if(x.Name.contains(s))
                        results.add(x);
                }
                ((RestaurantAdapter)myList.getAdapter()).update(results);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

}

