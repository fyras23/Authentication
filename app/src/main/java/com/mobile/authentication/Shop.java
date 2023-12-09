package com.mobile.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        TextView Id = findViewById(R.id.user);
        // Retrieve user's ID from the intent
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");

        Id.setText(userId);

        // Use the userId to fetch commands from the database
        // Update your UI accordingly
    }

}
