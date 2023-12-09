package com.mobile.authentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
        ImageView imageView = findViewById(R.id.destinationImageView);
        TextView productNameTextView = findViewById(R.id.destinationProductName);
        TextView productPriceTextView = findViewById(R.id.destinationProductPrice);


        // Retrieve data from the intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("productName");
        int productPrice = intent.getIntExtra("productPrice", 0);
        String productImage = intent.getStringExtra("productImage");

        // Update UI with the retrieved data
        productNameTextView.setText(productName);
        productPriceTextView.setText(String.valueOf(productPrice));

        // Load image using Glide or another image loading library
        Glide.with(this)
                .load(productImage)
                .placeholder(R.drawable.common_google_signin_btn_icon_dark) // Placeholder image resource
                .error(R.drawable.common_google_signin_btn_icon_dark_normal) // Error image resource
                .into(imageView);

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
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            String userId = currentUser.getUid();
            commandeclass.setUserId(userId);
        commandeclass.setNom(nom.getText().toString());
        commandeclass.setPrenom(prenom.getText().toString());
        commandeclass.setTelephone(telephone.getText().toString());
        commandeclass.setCity(city.getText().toString());
        commandeclass.setNameSK(getIntent().getStringExtra("productName"));
        commandeclass.setPrice(getIntent().getIntExtra("productPrice",0));


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