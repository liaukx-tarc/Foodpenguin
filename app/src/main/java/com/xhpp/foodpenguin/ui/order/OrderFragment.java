package com.xhpp.foodpenguin.ui.order;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    ImageButton curUpButton;
    ImageButton curDownButton;
    ImageButton recUpButton;
    ImageButton recDownButton;
    ImageButton backButton;
    CardView currentOrderContainer;
    RecyclerView recentOrderDetail;
    OrderAdapter orderAdapter;
    List<Order> orderList = new ArrayList<>();

    String uidDB;
    String shop_nameDB;
    Double total_priceDB;
    String dateDB;
    String idDB;
    int order_statusDB;
    int order_status;
    boolean has_order;

    TextView orderStatusText;
    TextView status1;
    TextView status2;
    TextView status3;
    TextView status4;
    TextView estimateTime;
    int estimateMin;
    String estimateTimeString;

    Handler handler;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_order,container,false);

        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        backButton = view.findViewById(R.id.backButton);
        curUpButton = view.findViewById(R.id.upButton);
        curDownButton = view.findViewById(R.id.downButton);
        recUpButton = view.findViewById(R.id.upButtonRecent);
        recDownButton = view.findViewById(R.id.downButtonRecent);

        backButton.setOnClickListener(pListener);
        curUpButton.setOnClickListener(pListener);
        curDownButton.setOnClickListener(pListener);
        recUpButton.setOnClickListener(pListener);
        recDownButton.setOnClickListener(pListener);

        currentOrderContainer = view.findViewById(R.id.currentOrderContainer);
        currentOrderContainer.setVisibility(View.GONE);
        recentOrderDetail = view.findViewById(R.id.recentOrderDetail);
        recentOrderDetail.setVisibility(View.GONE);

        orderAdapter = new OrderAdapter(orderList,this.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);
        recentOrderDetail.setLayoutManager((layoutManager));
        recentOrderDetail.setItemAnimator(new DefaultItemAnimator());
        recentOrderDetail.setAdapter((orderAdapter));

        orderStatusText = view.findViewById(R.id.orderStatusText);
        status1 = view.findViewById(R.id.status1);
        status2 = view.findViewById(R.id.status2);
        status3 = view.findViewById(R.id.status3);
        status4 = view.findViewById(R.id.status4);

        estimateMin = 0;
        order_status = 0;
        estimateTime = view.findViewById(R.id.estimatedTime);
        has_order = false;

        getData();
        return view;
    }

    private void getData()
    {
        final String UserId = fAuth.getCurrentUser().getUid();

        db.collection("orders")
                .whereEqualTo("uid", UserId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                order_statusDB = document.getDouble("order_status").intValue();
                                if(order_statusDB == 5)
                                {
                                    idDB = document.getId();
                                    shop_nameDB = document.getString("shop_name");
                                    total_priceDB = document.getDouble("total_price");
                                    dateDB = document.getString("date");
                                    Order order = new Order(uidDB, idDB, shop_nameDB, dateDB, total_priceDB);
                                    orderList.add(order);
                                }
                                else
                                {
                                    orderStatusText.setText(String.valueOf(order_statusDB));
                                }
                            }
                        }
                    }
                });
    }

    private final View.OnClickListener pListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.backButton:
                    getFragmentManager().popBackStackImmediate();
                    break;
                case R.id.upButton:
                    curUpButton.setVisibility(View.GONE);
                    curDownButton.setVisibility(View.VISIBLE);
                    currentOrderContainer.setVisibility(View.GONE);
                    break;
                case R.id.downButton:
                    curUpButton.setVisibility(View.VISIBLE);
                    curDownButton.setVisibility(View.GONE);
                    order_status = Integer.parseInt(orderStatusText.getText().toString());
                    if (order_status > 0 && order_status < 5)
                    {
                        has_order = true;
                    }
                    if(has_order)
                    {
                        currentOrderContainer.setVisibility(View.VISIBLE);
                        switch(order_status)
                        {
                            case 1:
                                status1.setBackgroundResource(R.drawable.circle_blue);
                                estimateMin = 20;
                                break;
                            case 2:
                                status1.setBackgroundResource(R.drawable.circle_blue);
                                status2.setBackgroundResource(R.drawable.circle_blue);
                                estimateMin = 15;
                                break;
                            case 3:
                                status1.setBackgroundResource(R.drawable.circle_blue);
                                status2.setBackgroundResource(R.drawable.circle_blue);
                                status3.setBackgroundResource(R.drawable.circle_blue);
                                estimateMin = 10;
                                break;
                            case 4:
                                status1.setBackgroundResource(R.drawable.circle_blue);
                                status2.setBackgroundResource(R.drawable.circle_blue);
                                status3.setBackgroundResource(R.drawable.circle_blue);
                                status4.setBackgroundResource(R.drawable.circle_blue);
                                estimateMin = 5;
                                break;
                        }
                        estimateTimeString = (estimateMin +" MIN");
                        estimateTime.setText(estimateTimeString);
                    }
                    break;
                case R.id.upButtonRecent:
                    recUpButton.setVisibility(View.GONE);
                    recDownButton.setVisibility(View.VISIBLE);
                    recentOrderDetail.setVisibility(View.GONE);
                    break;
                case R.id.downButtonRecent:
                    recUpButton.setVisibility(View.VISIBLE);
                    recDownButton.setVisibility(View.GONE);
                    recentOrderDetail.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}




