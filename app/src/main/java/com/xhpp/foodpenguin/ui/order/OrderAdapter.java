package com.xhpp.foodpenguin.ui.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orderList;
    private Context context;

    public OrderAdapter(List<Order> orderList, Context context)
    {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_order, viewGroup, false);
        return new OrderAdapter.OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.OrderViewHolder holder, int position)
    {
        holder.shop_name.setText(orderList.get(position).getShop_name());
        String total_priceString = "RM"+String.format("%.2f", orderList.get(position).getTotal_price());
        holder.total_price.setText(total_priceString);
        holder.date.setText(orderList.get(position).getDate());
        holder.id.setText(orderList.get(position).getId());
    }

    @Override
    public int getItemCount(){
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView shop_name;
        TextView total_price;
        TextView date;
        TextView id;

        public OrderViewHolder(View view){
            super(view);
            shop_name = view.findViewById(R.id.shop_name);
            total_price = view.findViewById(R.id.price);
            date = view.findViewById(R.id.date);
            id = view.findViewById(R.id.orderId);
        }
    }
}
