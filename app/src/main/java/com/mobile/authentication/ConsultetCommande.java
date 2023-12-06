package com.mobile.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ConsultetCommande extends AppCompatActivity {
List<Commandeclass> commandeclasses=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultet_commande);
        recyclerView=findViewById(R.id.recyclerView);

    }
}