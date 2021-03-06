package com.example.dai_prochild;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dai_prochild.src.tools;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class Cartazes extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipobd, nomebd;
    RecyclerView recview2;
    myadapter2 adapter2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();



    DatabaseReference dbRef = database.getReference("Utilizadores");

    Query query = dbRef.orderByKey();


    ValueEventListener queryValueListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
            Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

            while (iterator.hasNext()) {

                DataSnapshot next = (DataSnapshot) iterator.next();
                //   System.out.println( "Value = " + next.child("nome").getValue());
                nomebd = next.child("username").getValue().toString();

                if(UtilizadorLigado.equals(nomebd)){
                    tipobd = next.child("type").getValue().toString();
                    if(tipobd.equals("Criança")){
                        NavHostFragment.findNavController(Cartazes.this)
                                .navigate(R.id.action_cartazes2_to_materiais2);
                    }else if (tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(Cartazes.this)
                                .navigate(R.id.action_cartazes2_to_materiais2);

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
        return inflater.inflate(R.layout.cartazes, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recview2=(RecyclerView) view.findViewById(R.id.recview2);
        recview2.setLayoutManager(new LinearLayoutManager(getActivity()));


        FirebaseRecyclerOptions<tools> options =
                new FirebaseRecyclerOptions.Builder<tools>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Materiais"), tools.class)
                        .build();

        adapter2=new myadapter2(options);
        recview2.setAdapter(adapter2);


        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                query.addListenerForSingleValueEvent(queryValueListener);


            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter2.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter2.stopListening();
    }



}