package com.example.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.MainActivity2;
import com.example.movieapp.R;

import com.example.movieapp.databinding.MoviesItemListBinding;
import com.example.movieapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MoviesItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movies_item_list, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.moviesItemListBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MoviesItemListBinding moviesItemListBinding;

        public MovieViewHolder(MoviesItemListBinding moviesItemListBinding) {
            super(moviesItemListBinding.getRoot());
            this.moviesItemListBinding = moviesItemListBinding;

            moviesItemListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Movie clickMovie=movieArrayList.get(getAdapterPosition());
                    Toast.makeText(context,"Movie" +position,Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(context , MainActivity2.class);
                    intent.putExtra("title",clickMovie.getTitle());
                    intent.putExtra("description",clickMovie.getOverview());
                    intent.putExtra("voteAverage",clickMovie.getVoteAverage());
                    intent.putExtra("posterPath",clickMovie.getPosterPath());

                    context.startActivity(intent);


                }
            });
        }
    }
}

