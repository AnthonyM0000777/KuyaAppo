package com.cite.newscoopup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cite.newscoopup.modals.NewsHeadLines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadLines> headLine;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadLines> headLine, SelectListener listener) {
        this.context = context;
        this.headLine = headLine;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder (LayoutInflater.from (context).inflate (R.layout.headlines_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.text_title.setText (headLine.get (position).getTitle ());
        holder.text_source.setText (headLine.get (position).getSource ().getName ());

        if(headLine.get (position).getUrlToImage ()!=null){
            Picasso.get ().load (headLine.get (position).getUrlToImage ()).into (holder.img_headline);
        }
        holder.cardView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked (headLine.get (position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headLine.size ();
    }
}
