package com.xhpp.foodpenguin;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListViewClass extends Activity {

private String[] restaurants;
private String[] desc;
private Integer[] imgid;
private Activity context;

//listview for restaurants
    /*public ListViewClass(Activity context, String[] restaurants, String[] desc, Integer[] imgid){
        super(context, R.layout.fragment_main,restaurants);


        this.context=context;
        this.restaurants=restaurants;
        this.desc=desc;
        this.imgid=imgid;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {

            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.fragment_main,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)r.getTag();

        }
        viewHolder.img.setImageResource(imgid[position]);

            viewHolder.restaurants.setText(restaurants[position]);
            viewHolder.desc.setText(desc[position]);
        return r;
    }
    class ViewHolder
    {
        TextView restaurants;
        TextView desc;
        ImageView img;
        ViewHolder(View v)
        {
            restaurants=(TextView) v.findViewById(R.id.restaurants);
            desc=(TextView) v.findViewById(R.id.desc);
            img =(ImageView) v.findViewById(R.id.imageView);
        }

    }*/
//end of listing

//below is code from website sir give https://www.vogella.com/tutorials/AndroidListView/article.html
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

final ListView listview = (ListView) findViewById(R.id.myList);
        String[] values = new String[] {"McDonald's","KFC","Wendy's","Pizza Hut","Domino's Pizza","Burger King","A&W"};

final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
        list.add(values[i]);
        }
final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
@Override
public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

final String item = (String) parent.getItemAtPosition(position);
    final ViewPropertyAnimator viewPropertyAnimator = view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
        @Override
        public void run() {
            list.remove(item);
            adapter.notifyDataSetChanged();
            view.setAlpha(1);
        }
    });
}
        });
        }

private class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
//end of code from website


}
