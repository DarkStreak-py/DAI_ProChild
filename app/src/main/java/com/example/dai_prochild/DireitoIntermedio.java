package com.example.dai_prochild;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class DireitoIntermedio extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipobd, nomebd;

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


                    if(tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(DireitoIntermedio.this)
                                .navigate(R.id.action_direitoIntermedio_to_menu_PrincipalInstituicao);
                    }
                    if(tipobd.equals("Instituições")){
                        NavHostFragment.findNavController(DireitoIntermedio.this)
                                .navigate(R.id.action_direitoIntermedio_to_menu_PrincipalInstituicao);
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
        return inflater.inflate(R.layout.direitointermedio, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                query.addListenerForSingleValueEvent(queryValueListener);

            }
        });
        view.findViewById(R.id.btn_direitos4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(DireitoIntermedio.this)
                        .navigate(R.id.action_direitoIntermedio_to_direitosInserir);

            }
        });
        view.findViewById(R.id.btn_direitos3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DireitoIntermedio.this)
                        .navigate(R.id.action_direitoIntermedio_to_direitos_Eliminar);


            }
        });
        view.findViewById(R.id.btn_direitos5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DireitoIntermedio.this)
                        .navigate(R.id.action_direitoIntermedio_to_direitos);


            }
        });



    }


}