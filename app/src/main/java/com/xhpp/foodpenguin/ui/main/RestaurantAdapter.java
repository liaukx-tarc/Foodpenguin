package com.xhpp.foodpenguin.ui.main;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import com.xhpp.foodpenguin.R;
        import java.util.ArrayList;


public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
    private Context mContext;
    private int mResource;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imageView);

        TextView textView = convertView.findViewById(R.id.textView);

        TextView textView2 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(getItem(position).getImage());

        textView.setText(getItem(position).getName());

        textView2.setText(getItem(position).getDesc());

        return convertView;
    }
}
