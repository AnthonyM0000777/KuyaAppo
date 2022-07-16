package com.cite.newscoopup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {
    private ArrayList<NewsRVModal> newsRVModalArrayList;
    private Context context;
    private NewsClickInterface newsClickInterface;
    int lastPos = -1;


    public NewsRVAdapter(ArrayList<NewsRVModal> newsRVModalArrayList, Context context, NewsClickInterface newsClickInterface) {
        this.newsRVModalArrayList = newsRVModalArrayList;
        this.context = context;
        this.newsClickInterface = newsClickInterface;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NewsRVModal newsRVModal = newsRVModalArrayList.get(position);
        holder.newsDate.setText (newsRVModal.getNewsDate());
        holder.newsTV.setText (newsRVModal.getNewsName());
        //holder.uploader.setText (newsRVModal.getUploader ());
        Picasso.get().load(newsRVModal.getNewsImg()).into(holder.newsIV);
        setAnimation(holder.itemView, position);
        holder.newsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsClickInterface.onNewsClick(position);
            }
        });
    }


    private void setAnimation(View itemView, int position) {
        if (position > lastPos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }

    @Override
    public int getItemCount() {
        return newsRVModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView newsDate, newsTV, uploader;
        private ImageView newsIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsDate = itemView.findViewById (R.id.idTVNewsDate);
            newsIV = itemView.findViewById(R.id.idIVNews);
            newsTV = itemView.findViewById(R.id.idTVNewsName);
            //uploader = itemView.findViewById(R.id.idTVUploadBy);
        }
    }

    public interface NewsClickInterface {
        void onNewsClick(int position);
    }
}

