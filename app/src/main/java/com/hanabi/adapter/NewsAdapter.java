package com.hanabi.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hanabi.model.News;
import com.hanabi.recyclerviewdemo.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Activity activity;
    private ArrayList<News> newsArrayList;

    public NewsAdapter(Activity activity, ArrayList<News> newsArrayList) {
        this.activity = activity;
        this.newsArrayList = newsArrayList;
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgBg;
        private TextView txtTitle;
        private RelativeLayout rlItem;
        private Button btnOk;
        private NewsOnclickListener newsOnclickListener;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBg = itemView.findViewById(R.id.img_bg);
            txtTitle = itemView.findViewById(R.id.txt_title);
            rlItem = itemView.findViewById(R.id.rl_item_news);
            btnOk = itemView.findViewById(R.id.btn_ok);
            itemView.setOnClickListener(this);
            btnOk.setOnClickListener(this);

        }

        public void setItemClickListener(NewsOnclickListener newsOnclickListener) {
            this.newsOnclickListener = newsOnclickListener;
        }

        @Override
        public void onClick(View view) {
            newsOnclickListener.newsClicked(getAdapterPosition());
        }

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View itemView = layoutInflater.inflate(R.layout.item_list_anime, null);
        NewsViewHolder viewHolder = new NewsViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        News news = newsArrayList.get(position);
        holder.txtTitle.setText(news.getTitle());
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        holder.rlItem.getLayoutParams().height = height / 4;

        Glide.with(activity).load( news.getIdImg()).into(holder.imgBg);
        holder.setItemClickListener(new NewsOnclickListener() {
            @Override
            public void newsClicked(int position) {
                Toast.makeText(activity, Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public interface NewsOnclickListener {
        void newsClicked(int position);
    }


}
