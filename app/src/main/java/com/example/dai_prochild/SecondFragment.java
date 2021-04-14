    package com.example.dai_prochild;
import com.example.dai_prochild.src.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    static Utilizadores novo = new Utilizadores();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dataRef = database.getReference("Utilizadores");
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
                        dataRef.child(novo.getNome()).setValue(novo);
                    }

                }});}}

















