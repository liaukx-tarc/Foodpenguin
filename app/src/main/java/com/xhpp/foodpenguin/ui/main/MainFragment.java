package com.xhpp.foodpenguin.ui.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.xhpp.foodpenguin.ListViewClass;
import com.xhpp.foodpenguin.R;


public class MainFragment extends Fragment
{
    SearchView mySearchView;
    ListView myList;

    String[] restaurants={"McDonald's","KFC","Wendy's","Pizza Hut","Domino's Pizza","Burger King","A&W"};
    String[] desc={"mcd","KFC","Wendy's","Pizza Hut","Domino's Pizza","Burger King","A&W"};
    Integer[] imgid={R.drawable.mcd,R.drawable.kfc,R.drawable.wendys,R.drawable.pizzahut,R.drawable.domino,R.drawable.burger,R.drawable.aandw};

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mySearchView = (SearchView)view.findViewById(R.id.searchView);
        myList = (ListView)view.findViewById(R.id.myList);

        //final ListViewClass listViewClass = new ListViewClass(getActivity(),restaurants,desc,imgid);
        //myList.setAdapter(listViewClass);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG).show();
            }
        });

        //search bar
        /*mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                listViewClass.getFilter().filter(s);
                return false;
            }
        });*/

        return view ;
    }

}