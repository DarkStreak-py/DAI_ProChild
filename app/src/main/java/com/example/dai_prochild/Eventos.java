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

public class Eventos extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipobd, nomebd, nomeint;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private Spinner spinner5;
    private String spinner6;
    DatabaseReference eventos = database.getReference("Eventos");
    DatabaseReference dbRef = database.getReference("Utilizadores");

    Query query = dbRef.orderByKey();
    Query query3 = eventos.orderByKey();
    Query query4 = eventos.orderByKey();
    Query query5 = dbRef.orderByKey();

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
                        NavHostFragment.findNavController(Eventos.this)
                                .navigate(R.id.action_eventos_to_menu_Principal);
                    }else if (tipobd.equals("Guardiões")){
                        NavHostFragment.findNavController(Eventos.this)
                                .navigate(R.id.action_eventos_to_menu_PrincipalGuardiao);

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
        return inflater.inflate(R.layout.eventos, container, false);
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

                    String nome = next.child("nome").getValue().toString();
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
                query.addListenerForSingleValueEvent(queryValueListener);



            }
        });

        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner6 = spinner5.getSelectedItem().toString();





                System.out.println(nomeint);
                query4.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                        Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                        while (iterator.hasNext()) {

                            DataSnapshot next = (DataSnapshot) iterator.next();

                            String nome = next.child("nome").getValue().toString();
                            String datas = next.child("data").getValue().toString();


                            System.out.println(spinner5.getSelectedItem().toString());
                            if(nome.equals(spinner5.getSelectedItem().toString())){
                                String a = next.child("instituicao").getValue().toString();
                                int[]arr= Arrays.stream(datas.split(",")).mapToInt(Integer::parseInt).toArray();

                                Calendar beginCal = Calendar.getInstance();

                                 beginCal.set(arr[0],arr[1],arr[2],arr[3],arr[4]);


                                Calendar endCal = Calendar.getInstance();



                                Intent intent = new Intent(Intent.ACTION_INSERT);
                                intent.setType("vnd.android.cursor.item/event");
                                intent.putExtra(CalendarContract.Events.TITLE, nome);

                                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Na instituição: "+a);
                                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());

                                intent.putExtra(CalendarContract.Events.STATUS, 1);
                                intent.putExtra(CalendarContract.Events.VISIBLE, 0);
                                intent.putExtra(CalendarContract.Events.HAS_ALARM, 1);
                                startActivity(intent);
                            }





                            }
                        }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });





        }});}}



