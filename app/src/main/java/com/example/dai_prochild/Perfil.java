package com.example.dai_prochild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.dai_prochild.src.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dai_prochild.src.ListaUtilizadores;
import com.example.dai_prochild.src.Utilizadores;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Perfil extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipoLigado =FirstFragment.tipoLigado;
    String nomeligado =FirstFragment.nomeligado;
    Utilizadores user;

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
                    user = dataSnapshot.getValue(Utilizadores.class);
                    tipobd = next.child("type").getValue().toString();
                    if(tipobd.equals("Criança")){
                        NavHostFragment.findNavController(Perfil.this)
                                .navigate(R.id.action_perfil_to_menu_Principal);
                    }else if (tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(Perfil.this)
                                .navigate(R.id.action_perfil_to_menu_PrincipalGuardiao);

                    }else if(tipobd.equals("Instituições")){
                        NavHostFragment.findNavController(Perfil.this)
                                .navigate(R.id.action_perfil_to_menu_PrincipalInstituicao);
                    }

                }


            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };


    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState



    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.perfil, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView showName =  view.findViewById(R.id.textView10) ;
        TextView showUsername =  view.findViewById(R.id.textView11) ;
        TextView showTipo =  view.findViewById(R.id.textView19) ;
        EditText newPwd = view.findViewById(R.id.editPassword);

        showName.setText(nomeligado);
        showUsername.setText(UtilizadorLigado);
        showTipo.setText(tipoLigado);

        view.findViewById(R.id.editarPerfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newPwdTxt = newPwd.getText().toString();

                    if (!newPwdTxt.equals("")) {
                    ValueEventListener queryValueListener = new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                            Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                            while (iterator.hasNext()) {

                                DataSnapshot next = (DataSnapshot) iterator.next();
                                //   System.out.println( "Value = " + next.child("nome").getValue());
                                nomebd = next.child("username").getValue().toString();
                                if(UtilizadorLigado.equals(nomebd)) {
                                    user = dataSnapshot.getValue(Utilizadores.class);
                                    String nomeUser = next.child("nome").getValue().toString();
                                    dbRef.child(nomeUser).child("password").setValue(newPwdTxt);
                                }
                            }
                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    };

                        query.addListenerForSingleValueEvent(queryValueListener);

                } else if (newPwdTxt.equals("")) {}
            }
        });


        view.findViewById(R.id.btn_back2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                query.addListenerForSingleValueEvent(queryValueListener);

            }
        });



    }


}