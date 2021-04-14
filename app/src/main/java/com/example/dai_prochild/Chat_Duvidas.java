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

public class Chat_Duvidas extends Fragment {
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

                    if(tipobd.equals("Criança")){
                        NavHostFragment.findNavController(Chat_Duvidas.this)
                                .navigate(R.id.action_chat_Duvidas_to_menu_Principal);
                    }else if (tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(Chat_Duvidas.this)
                                .navigate(R.id.action_chat_Duvidas_to_menu_PrincipalGuardiao);

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
        return inflater.inflate(R.layout.chat_duvidas, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText duvidas =  view.findViewById(R.id.duvidas) ;
        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query.addListenerForSingleValueEvent(queryValueListener);



            }
        });
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                //    intent.putExtra(Intent.EXTRA_SUBJECT, "Sugestões ProChild 'Direitos das Crianças'");
                //  intent.putExtra(Intent.EXTRA_TEXT, "Sugestões:");

                intent.setData(Uri.parse("mailto:grupo42dai@gmail.com?subject=Duvidas%20Pro%20Child%20'Direitos%20das%20crianças'&body="+duvidas.getText().toString())); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);


                duvidas.setText("");


            }
        });


    }


}