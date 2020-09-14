package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xhpp.foodpenguin.R;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    ArrayList<Restaurant> arrayList;
    SearchView mySearchView;
    private RecyclerView mRecyclerView;
    private RestaurantAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        mySearchView = view.findViewById(R.id.searchView);
//        myList = view.findViewById(R.id.listView);


        createList();
        mRecyclerView = view.findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RestaurantAdapter(arrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_bar,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
            });
    }


    private void createList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Restaurant(R.drawable.mcd, "McDonalds", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.kfc, "KFC", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.burgerking, "Burger King", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.domino, "Domino's Pizza", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.aandw, "A&W", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.pizzahut, "Pizza Hut", "Fast Food"));
        arrayList.add(new Restaurant(R.drawable.wendy, "Wendy's", "Fast Food"));
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


