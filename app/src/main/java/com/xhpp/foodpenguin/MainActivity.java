package com.xhpp.foodpenguin;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.promotion, R.id.cart, R.id.main,R.id.wallet,R.id.account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                int id= destination.getId();

                switch(id)
                {
                    case R.id.wallet:
                        Toast.makeText(MainActivity.this,"Wallet", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.penguin:
                        Toast.makeText(MainActivity.this, "Penguin", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cart:
                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.promotion:
                        Toast.makeText(MainActivity.this, "Promotion", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

}