package com.mobile.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnLogOut;
    FirebaseAuth mAuth;
    Button btnToLocation;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogOut=findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        Intent i= new Intent(getApplicationContext(),LoginActivity.class);
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("sneakers"), MainModel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);
        System.out.println("aaaa");
        System.out.println(options.getOwner());


    }
    public void logout(View v){
        mAuth.signOut();
        Intent i=new Intent(getApplicationContext(),LoginActivity.class);

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        else{
            mainAdapter.startListening();

        }
    }
    public void oppenaddbasquest(android.view.View view) {
        Intent intent = new Intent(this, Commande.class);
        startActivity(intent);
    }



    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }


}
