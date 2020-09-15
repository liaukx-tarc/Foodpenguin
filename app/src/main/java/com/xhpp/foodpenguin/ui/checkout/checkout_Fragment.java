package com.xhpp.foodpenguin.ui.checkout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Order;
import com.xhpp.foodpenguin.ui.account.AccountViewModel;
import com.xhpp.foodpenguin.ui.cart.CartFragment;
import com.xhpp.foodpenguin.ui.order.OrderAdapter;
import com.xhpp.foodpenguin.ui.order.OrderFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class checkout_Fragment extends Fragment implements View.OnClickListener{

    ImageButton back;
    Button confirm;
    RadioGroup checkout;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    RadioButton wallet_amount;
    int price = 15;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout_fragment, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Calendar c = Calendar.getInstance();

        back = view.findViewById(R.id.back);
        confirm = view.findViewById(R.id.confirm_button);
        checkout = view.findViewById(R.id.payment_method);
        wallet_amount = view.findViewById(R.id.wallet_text);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        back.setOnClickListener(this);
        confirm.setOnClickListener(this);

        getData();

        return view;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.back:
                CartFragment cartFragment = new CartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), cartFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.confirm_button:
                if(checkout.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getActivity(),"Please Select a Payment Method", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    String formattedDate = df.format(c.getTime());
                    String shopName = getArguments().getString("shop");
                    Order order = new Order("1234", "OD014", shopName, formattedDate, 15);
                    db.collection("orders").add(order);
                    OrderFragment orderFragment = new OrderFragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), orderFragment);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                }
                break;
        }

    }

    public void getData() {
        String userId = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(userId);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists())
                    {
                        Double walletAmountDB = document.getDouble("walletAmount");
                        wallet_amount.setText("Penguin Wallet\nRM"+String.format("%.2f", walletAmountDB));
                    }
                }
            }
        });
    }

    public void saveOrder(){

    }



}