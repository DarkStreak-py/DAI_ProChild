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

public class EscolherInstituicao extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dataRef = database.getReference("Utilizadores");
    Utilizadores user = SecondFragment.novo;

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.escolher_inst, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EditText insttxt =  view.findViewById(R.id.txtInst) ;

        view.findViewById(R.id.esclhInst).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                user.setNomeInst(insttxt.getText().toString());
                dataRef.child(user.getNome()).setValue(user);
            }
        });
    }
}

