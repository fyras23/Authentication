package com.mobile.authentication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ShopAdapter extends FirebaseRecyclerAdapter<ShopModel,ShopAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ShopAdapter(@NonNull FirebaseRecyclerOptions<ShopModel> options) {

        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ShopAdapter.myviewholder holder, int position, @NonNull ShopModel model) {
        holder.name.setText(model.getName());
        holder.price.setText(String.valueOf(model.getPrice()));

        Glide.with(holder.img.getContext())
                .load(model.getImg())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        // Set click listener on the entire item view

    }


    @NonNull

    @Override
    public ShopAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_shop,parent,false);
        return new ShopAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,price;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.sh1);
            name=itemView.findViewById(R.id.names);
            price=itemView.findViewById(R.id.prices);
        }
    }

}




