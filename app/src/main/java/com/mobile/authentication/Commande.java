package com.mobile.authentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class Commande extends AppCompatActivity {
    ImageView locaton;
    EditText city,nom,prenom,telephone,adresse;
    ProgressDialog progressDialog;
    FirebaseApp firebaseApp;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    Commandeclass commandeclass=new Commandeclass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        locaton = findViewById(R.id.locaton);
        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        telephone=findViewById(R.id.telephone);
        adresse=findViewById(R.id.adress);
        city=findViewById(R.id.city);
        firebaseApp=FirebaseApp.initializeApp(this);
        locaton.setOnClickListener(v -> {
            startActivityForResult(new Intent(getApplicationContext(),CurrentLocation.class),100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      if(resultCode==RESULT_OK){
          if(requestCode==100){
              city.setText(data.getStringExtra("city"));
              commandeclass.setCity(data.getStringExtra("city"));
              commandeclass.setLatitude(data.getDoubleExtra("latitude",0));
              commandeclass.setLongitude(data.getDoubleExtra("longitude",0));

          }
      }

    }
    public void addCommande(android.view.View view) {
        try{
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        String city1=city.getText().toString();
        if(city1.isEmpty()){
            Toast.makeText(this, "Please enter city", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            return;
        }
        commandeclass.setNom(nom.getText().toString());
        commandeclass.setPrenom(prenom.getText().toString());
        commandeclass.setTelephone(telephone.getText().toString());
        commandeclass.setCity(city.getText().toString());


            firebaseDatabase.getReference().child("commandes").push().setValue(commandeclass).addOnSuccessListener(aVoid -> {
            Toast.makeText(this, "Commande added successfully", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            city.setText("");
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Failed to add Commande", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        });
    }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.println(e.getMessage());
            progressDialog.dismiss();
        }
    }
}