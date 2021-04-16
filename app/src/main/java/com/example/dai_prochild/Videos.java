package com.example.dai_prochild;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dai_prochild.src.tools;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Videos extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipobd, nomebd;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference videos = database.getReference("Videos");
    Query query3 = videos.orderByKey();
    Query query4 = videos.orderByKey();
    private Spinner spinner5;
    private Spinner spinner6;
    DatabaseReference dbRef = database.getReference("Utilizadores");

    Query query = dbRef.orderByKey();
    public static String Url;


    ValueEventListener queryValueListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
            Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

            while (iterator.hasNext()) {

                DataSnapshot next = (DataSnapshot) iterator.next();
                //   System.out.println( "Value = " + next.child("nome").getValue());
                nomebd = next.child("username").getValue().toString();
                System.out.println(UtilizadorLigado);
                System.out.println(nomebd);
                if(UtilizadorLigado.equals(nomebd)){
                    System.out.println("entrou");
                    tipobd = next.child("type").getValue().toString();
                    if(tipobd.equals("Criança")){
                        NavHostFragment.findNavController(Videos.this)
                                .navigate(R.id.action_videos_to_materiais2);
                    }else if (tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(Videos.this)
                                .navigate(R.id.action_videos_to_materiais2);

                    }

                }


            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.videos, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner5 = (Spinner)view.findViewById(R.id.spinner5);
        query3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                final List<String> titleList = new ArrayList<String>();
                while (iterator.hasNext()) {

                    DataSnapshot next = (DataSnapshot) iterator.next();

                    String nome = next.child("name").getValue().toString();
                    titleList.add(nome);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, titleList);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner5.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("yooo");
                query.addListenerForSingleValueEvent(queryValueListener);



            }
        });

        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                query4.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                        Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                        while (iterator.hasNext()) {

                            DataSnapshot next = (DataSnapshot) iterator.next();

                            String nome = next.child("name").getValue().toString();



                            if(nome.equals(spinner5.getSelectedItem().toString())){
                                Url= next.child("purl").getValue().toString();
                                NavHostFragment.findNavController(Videos.this)
                                        .navigate(R.id.action_videos_to_myAdapterVideo);

                            }





                        }
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });





            }});}}