package com.xhpp.foodpenguin.ui.promotion;

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

public class PromotionAdapter extends ArrayAdapter<Promotion> {
    private Context pContext;
    private int pResource;

    public PromotionAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Promotion> objects) {
        super(context, resource, objects);
        this.pContext = context;
        this.pResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(pContext);

        convertView = layoutInflater.inflate(pResource,parent,false);

        ImageView imageForPromotion = convertView.findViewById(R.id.imageForPromotion);

        TextView titleForPromotion = convertView.findViewById(R.id.titleForPromotion);

        TextView contextForPromotion = convertView.findViewById(R.id.contextForPromotion);

        imageForPromotion.setImageResource(getItem(position).getImageForPromo());

        titleForPromotion.setText(getItem(position).getTitleForPromo());

        contextForPromotion.setText(getItem(position).getDescForPromo());

        return convertView;
    }
}

