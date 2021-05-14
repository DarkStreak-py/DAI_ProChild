    package com.example.dai_prochild;
import com.example.dai_prochild.src.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class SecondFragment extends Fragment {
        String usernamebd, username;
        Boolean sucess = true;
        Boolean check = true;
    static Utilizadores novo = new Utilizadores();
    FirebaseDatabase database = FirebaseDatabase.getInstance();


        DatabaseReference dbRef = database.getReference("Utilizadores");

        Query query = dbRef.orderByKey();




    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        EditText nometxt =  view.findViewById(R.id.txtNome) ;
        EditText mailtxt =  view.findViewById(R.id.txtEmail) ;
        EditText passtxt =  view.findViewById(R.id.txtPass) ;
        Spinner txtspinner =  view.findViewById(R.id.spinner) ;





        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);


            }});


            view.findViewById(R.id.criarconta_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    check=true;
                    sucess=true;
                    if (nometxt.getText().toString().replaceAll("\\s+","").isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Insira o seu nome de utilizador")
                                .setTitle("Campo Obrigatório");
                        builder.create();
                        builder.show();
                    }
                    else if (mailtxt.getText().toString().replaceAll("\\s+","").isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Insira um username")
                                .setTitle("Campo Obrigatório");
                        builder.create();
                        builder.show();
                    }
                    else if (passtxt.getText().toString().isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Insira uma password")
                                .setTitle("Campo Obrigatório");
                        builder.create();
                        builder.show();
                    }
                    else {

                        novo.setNome(nometxt.getText().toString());
                        novo.setUsername(mailtxt.getText().toString());

                        //ver se username já existe
                        username = novo.getUsername();

                        query.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                                // while (iterator.hasNext()) {
                                while (iterator.hasNext()) {
                                    DataSnapshot next = (DataSnapshot) iterator.next();
                                    //   System.out.println( "Value = " + next.child("nome").getValue());
                                    usernamebd = next.child("username").getValue().toString();

                                    if(username.equals(usernamebd) && check) {
                                        sucess = false;

                                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                        builder.setMessage("Username já existe");
                                        builder.create();
                                        builder.show();
                                        //já existe
                                        System.out.println("fi if" + sucess);
                                        System.out.println("fi check" + check);
                                    };

                                }
                                System.out.println("se if" + sucess);
                                System.out.println("se check" + check);
                                if (sucess == true && check==true) {
                                    check = false;

                                    novo.setNome(nometxt.getText().toString());
                                    novo.setUsername(mailtxt.getText().toString());
                                    novo.setPassword(passtxt.getText().toString());

                                    novo.setType(txtspinner.getSelectedItem().toString());
                                    nometxt.setText("");
                                    mailtxt.setText("");
                                    passtxt.setText("");
                                    if (txtspinner.getSelectedItem().toString().equals("Instituições")) {
                                        NavHostFragment.findNavController(SecondFragment.this)
                                                .navigate(R.id.action_SecondFragment_to_escolherInstituicao);
                                    } else {
                                        novo.setNomeInst("");
                                        dbRef.child(novo.getUsername()).setValue(novo);
                                    }

                                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                    builder.setMessage("Utilizador criado com sucesso");
                                    builder.create();
                                    builder.show();

                                }

                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }




                        });



                    }}});}}

















