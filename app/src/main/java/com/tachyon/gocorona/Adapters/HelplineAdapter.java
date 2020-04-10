package com.tachyon.gocorona.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tachyon.gocorona.R;

import java.util.ArrayList;

public class HelplineAdapter extends RecyclerView.Adapter<HelplineAdapter.ViewHolder>  {
    Context context;
    ArrayList<String> state;
    ArrayList<String> num;

    public HelplineAdapter(Context context, ArrayList<String> state,ArrayList<String> num)
    {
        this.context = context;
        this.state = state;
        this.num = num;
    }

    @NonNull
    @Override
    public HelplineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_helpline,parent,false);

        HelplineAdapter.ViewHolder viewHolder = new HelplineAdapter.ViewHolder(v);
        //Toast.makeText(context, ngos.size()+"", Toast.LENGTH_SHORT).show();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineAdapter.ViewHolder holder, int position) {
        holder.state.setText(state.get(position));
        holder.number.setText(num.get(position));
    }

    @Override
    public int getItemCount() {
        return state.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView state;
        public TextView number;

        public ViewHolder(View v) {
            super(v);
            state = (TextView) v.findViewById(R.id.state_name);
            number = (TextView) v.findViewById(R.id.number);
        }
    }
}
