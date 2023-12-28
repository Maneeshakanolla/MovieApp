package com.example.movieapp;

import static com.example.movieapp.BR.posterPath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.movieapp.databinding.ActivityMain2Binding;
import com.example.movieapp.model.Movie;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityMain2Binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);


        Intent intent= getIntent();
        Movie movie= intent.getParcelableExtra("movie");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String voteAverage=getIntent().getStringExtra("voteAverage");
        String posterPath=getIntent().getStringExtra("posterPath");

          String imgPath = "https://image.tmdb.org/t/p/w500/" + posterPath;
          Glide.with(this).load(imgPath).into(activityMain2Binding.posterPath);


          activityMain2Binding.setTitle(title);
          activityMain2Binding.setDescription(description);
          activityMain2Binding.setVoteAverage(voteAverage);



        //activityMain2Binding.setMovie(movie);
        activityMain2Binding.executePendingBindings();


    }
}