package com.mobile.authentication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ShopActivity extends AppCompatActivity {
    Button btnLogOut;
    FirebaseAuth mAuth;
    Button btnToLocation;
    ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        RecyclerView recyclerView = findViewById(R.id.SrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ShopModel> options =
                new FirebaseRecyclerOptions.Builder<ShopModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("sneakers"), ShopModel.class)
                        .build();

        shopAdapter = new ShopAdapter(options);
        recyclerView.setAdapter(shopAdapter);






//        List<CartItem> cartItemList = generateDummyData(); // You should replace this with your actual data
//        CartAdapter adapter = new CartAdapter(this, cartItemList);
//        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        shopAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        shopAdapter.stopListening();
    }


}
