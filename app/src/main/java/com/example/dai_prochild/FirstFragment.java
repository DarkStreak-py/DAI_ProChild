package com.example.dai_prochild;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dai_prochild.src.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;


import java.util.Iterator;


public class FirstFragment extends Fragment {
    String nome, pwd, nomebd, pwdbd , tipo, usernamebd;
    Boolean loggedIn = false;
    public static String utilizadorLigado, tipoLigado, nomeligado;




    FirebaseDatabase database = FirebaseDatabase.getInstance();



    DatabaseReference dbRef = database.getReference("Utilizadores");

    Query query = dbRef.orderByKey();


    ValueEventListener queryValueListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
            Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

           // while (iterator.hasNext()) {
            while (iterator.hasNext()) {
                DataSnapshot next = (DataSnapshot) iterator.next();
             //   System.out.println( "Value = " + next.child("nome").getValue());
                nomebd = next.child("nome").getValue().toString();
                usernamebd = next.child("username").getValue().toString();
                pwdbd = next.child("password").getValue().toString();
                tipo = next.child("type").getValue().toString();
                if(nome.equals(usernamebd) && pwdbd.equals(pwd)){
                    loggedIn = true;
                    utilizadorLigado = usernamebd;
                    nomeligado = next.child("nome").getValue().toString();
                    tipoLigado =tipo;
                        if(tipo.equals("Guardiões")){
                           // System.out.println("Guardião");

                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_menu_PrincipalGuardiao);


                        }else if (tipo.equals("Criança")) {
                            //System.out.println("Criança");
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_menu_Principal);
                        }else if(tipo.equals("Instituições")){
                          //  System.out.println("Instituições");
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_menu_PrincipalInstituicao);
                        }
                }



            }
            if (loggedIn == false) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Utilizador não está registado")
                        .setTitle("Erro");
                builder.create();
                builder.show();
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
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText usertxt =  view.findViewById(R.id.user_login) ;
        EditText pwdtxt =  view.findViewById(R.id.pass_login) ;


        view.findViewById(R.id.textView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        



        view.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 nome = usertxt.getText().toString();
                 pwd = pwdtxt.getText().toString();

                 if (nome.isEmpty() || nome.replaceAll("\\s+","").isEmpty()) {
                     AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                     builder.setMessage("Insira o seu nome de utilizador")
                             .setTitle("Erro");
                     builder.create();
                     builder.show();
                 }

                else if (pwd.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Insira a sua password")
                            .setTitle("Erro");
                    builder.create();
                    builder.show();
                }
                else {
                     query.addListenerForSingleValueEvent(queryValueListener);
                     }


            }
        });


    }




}