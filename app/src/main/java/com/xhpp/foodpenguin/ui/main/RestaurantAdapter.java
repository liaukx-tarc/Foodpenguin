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
    private ArrayList<Restaurant> arrayList;
    private ArrayList<Restaurant> searchlist;

    private OnItemClickListener mListener;

    public RestaurantAdapter(ArrayList<Restaurant> exampleList, OnItemClickListener onItemClickListener) {
        this.arrayList = exampleList;
        searchlist = new ArrayList<>(exampleList);
        this.mListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    ;

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        OnItemClickListener onItemClickListener;

        public RestaurantViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants, parent, false);
        return new RestaurantViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        final Restaurant restaurant = arrayList.get(position);
        holder.mImageView.setImageResource(restaurant.getImageResource());
        holder.mTextView1.setText(restaurant.getText1());
        holder.mTextView2.setText(restaurant.getText2());
    }


    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Restaurant> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(searchlist);
            } else {
                String word = charSequence.toString().toLowerCase().trim();

                for (Restaurant x : searchlist) {
                    if (x.getText1().toLowerCase().contains(word)) {
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
            arrayList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
