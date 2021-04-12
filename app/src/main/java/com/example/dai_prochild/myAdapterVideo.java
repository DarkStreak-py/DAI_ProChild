package com.example.dai_prochild;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.net.Uri;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dai_prochild.src.tools;
import com.example.dai_prochild.src.*;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


import de.hdodenhof.circleimageview.CircleImageView;

public class myAdapterVideo extends FirebaseRecyclerAdapter<tools, myAdapterVideo.myviewholder> {


    public myAdapterVideo(@NonNull FirebaseRecyclerOptions<tools> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myAdapterVideo.myviewholder holder, int position, @NonNull tools tools)
    {

        /*DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory( "video");
        ExtractorsFactory extractorFactory = new DefaultExtractorsFactory();
        Uri video = Uri.parse(tools.getPurl());
        MediaSource mediaSource = new ExtractorMediaSource(video, dataSourceFactory, extractorFactory, null, null);
        playerView.setPlayer(exoPlayer);
        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(false);*/
    }

    @NonNull
    @Override
    public myAdapterVideo.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_video,parent,false);
        return new myAdapterVideo.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

           // playerView = itemView.findViewById(R.id.exoplayer_item);
        }

    }

    }
