package com.xhpp.foodpenguin.ui.main;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Filter;
        import android.widget.Filterable;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.RecyclerView;
        import com.xhpp.foodpenguin.R;
        import java.util.ArrayList;
        import java.util.List;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> implements Filterable {
    private ArrayList <Restaurant> arrayList;
    private ArrayList<Restaurant> searchlist;

    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    };

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }
    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public RestaurantViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RestaurantAdapter(ArrayList<Restaurant> exampleList) {
        this.arrayList = exampleList;
        searchlist = new ArrayList<>(exampleList);
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants,parent,false);
        RestaurantViewHolder evh = new RestaurantViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        final Restaurant restaurant = arrayList.get(position);

        holder.mImageView.setImageResource(restaurant.getImageResource());
        holder.mTextView1.setText(restaurant.getText1());
        holder.mTextView2.setText(restaurant.getText2());
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentJump(restaurant);
            }
        });
    }

    private void fragmentJump(Restaurant restaurant) {
        mFragnment = new Fragment()
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter()
    {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Restaurant> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() ==0)
            {
                filteredList.addAll(searchlist);
            }
            else
            {
                String word = charSequence.toString().toLowerCase().trim();

                for(Restaurant x:searchlist)
                {
                    if(x.getText1().toLowerCase().contains(word))
                    {
                        filteredList.add(x);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            arrayList.clear();
            searchlist.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


//        public void update(ArrayList<Restaurant> results)
//    {
//        arrayList = new ArrayList<>();
//        arrayList.addAll(results);
//        notifyDataSetChanged();
//    }

//    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurant> objects) {
//        super(context, resource, objects);
//        this.mContext = context;
//        this.mResource = resource;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
//
//        convertView = layoutInflater.inflate(mResource,parent,false);
//
//        ImageView imageView = convertView.findViewById(R.id.imageView);
//
//        TextView textView = convertView.findViewById(R.id.textView);
//
//        TextView textView2 = convertView.findViewById(R.id.textView2);
//
//        imageView.setImageResource(getItem(position).getImage());
//
//        textView.setText(getItem(position).getName());
//
//        textView2.setText(getItem(position).getDesc());
//
//        return convertView;
//    }
}
