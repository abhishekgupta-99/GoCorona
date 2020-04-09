package com.tachyon.gocorona.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tachyon.gocorona.R;
import com.tachyon.gocorona.models.Donate_ngo_model;

import java.util.ArrayList;


/**
 * * Created by abhishek on 3/2020.
 */

public class Donate_Adapter extends RecyclerView.Adapter<Donate_Adapter.ViewHolder>
{
  private final Context context;
    private final ArrayList<Donate_ngo_model> ngos;


    public Donate_Adapter(Context context, ArrayList<Donate_ngo_model> ngos) {

        this.context = context;
        this.ngos = ngos;


    }

    class ViewHolder extends RecyclerView.ViewHolder implements  View.OnLongClickListener {
        public ImageView big_image_url;
        public TextView name;
        public CardView web_card;
        public TextView description;
        ItemLongClickListener itemLongClickListener;

        ViewHolder(View view) {
            super(view);
            name=view.findViewById(R.id.name);
            description=view.findViewById(R.id.desc);
            big_image_url=view.findViewById(R.id.ngo_image);


        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }

    }


        @NonNull
    @Override
    public Donate_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_donate,viewGroup,false);

            ViewHolder viewHolder = new ViewHolder(v);
            Toast.makeText(context, ngos.size()+"", Toast.LENGTH_SHORT).show();
            return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Donate_Adapter.ViewHolder holder, int i) {
        String short_desc;

        Donate_ngo_model ngo = ngos.get(i);
        holder.name.setText(ngo.name);
        Toast.makeText(context, ngo.name, Toast.LENGTH_SHORT).show();
        if((ngo.description).length()>150)
        {
             short_desc=(ngo.description).substring(0,150)+"...Read More";
            holder.description.setText(short_desc);
        }
        else{
            holder.description.setText(ngo.description);
        }

        try {
            Glide.with(context).load(ngo.image_url).centerCrop().into(holder.big_image_url);
        } catch (Exception ignored) {


        }
    }

    @Override
    public int getItemCount() {
        return ngos.size();
    }


    }