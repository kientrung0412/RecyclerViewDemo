package com.hanabi.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.hanabi.adapter.NewsAdapter;
import com.hanabi.model.News;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<News> newsList;
    private RecyclerView rcvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    private void initviews() {
        rcvNews = findViewById(R.id.rcv_news);

        newsList = new ArrayList<>();
        createNewsList();
        NewsAdapter newsAdapter = new NewsAdapter(this, newsList);
        rcvNews.setAdapter(newsAdapter);
        rcvNews.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createNewsList() {

//        newsList.add(new News("Ảnh " + ((View) rcvNews).getMeasuredHeight(), R.drawable.one));
        newsList.add(new News("Ảnh 2", R.drawable.two));
    }

}