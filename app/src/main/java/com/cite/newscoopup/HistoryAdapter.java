package com.cite.newscoopup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<LocationHelper> list;
    String uri;

    public HistoryAdapter(Context context, ArrayList<LocationHelper> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (context).inflate (R.layout.location_item,parent, false);
        return new MyViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        LocationHelper helper = list.get (position);
        holder.name.setText (helper.getName ());
       holder.number.setText (helper.getNumber ());
        holder.address.setText (helper.getAddress ());
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, number, address;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById (R.id.idNameView);
           number = itemView.findViewById (R.id.idNumberView);
            address = itemView.findViewById (R.id.idAddressView);
        }
    }
}
