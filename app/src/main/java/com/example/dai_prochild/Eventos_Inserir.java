package com.example.dai_prochild;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dai_prochild.src.Events;
import com.example.dai_prochild.src.Type;
import com.example.dai_prochild.src.Utilizadores;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Eventos_Inserir extends Fragment {
    String UtilizadorLigado =FirstFragment.utilizadorLigado;
    String tipobd, nomebd,instituicao;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private Events eventos;

    DatabaseReference dbRef = database.getReference("Utilizadores");
    DatabaseReference dbRefa = database.getReference("Eventos");
    Query query = dbRef.orderByKey();
    Query query2 = dbRef.orderByKey();
    Query query1 = dbRefa.orderByKey();

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
                    if(tipobd.equals("Instituições")){
                        NavHostFragment.findNavController(Eventos_Inserir.this)
                                .navigate(R.id.action_eventos_Inserir_to_menu_PrincipalInstituicao);
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
        return inflater.inflate(R.layout.eventos_inserir, container, false);
    }
    String date;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextTextPersonName =  view.findViewById(R.id.editTextTextPersonName) ;

        CalendarView calendario = (CalendarView) view.findViewById(R.id.calendarView);

        view.findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query.addListenerForSingleValueEvent(queryValueListener);



            }
        });
        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query2.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                        Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                        while (iterator.hasNext()) {

                            DataSnapshot next = (DataSnapshot) iterator.next();
                            nomebd = next.child("username").getValue().toString();
                            System.out.println("Ligado"+UtilizadorLigado);
                            System.out.println(nomebd);
                            if(UtilizadorLigado.equals(nomebd)){
                                instituicao = next.child("nomeInst").getValue().toString();
                                System.out.println(instituicao);
                                System.out.println(instituicao);
                                Events novo = new Events();
                                //  SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
                                //  String selectedDate = sdf.format(new Date(calendario.getDate())); // get selected date in milliseconds
                                novo.setNome(editTextTextPersonName.getText().toString());
                                novo.setData(date);
                                novo.setInstituicao(instituicao);
                                dbRefa.child(novo.getNome()).setValue(novo);
                                editTextTextPersonName.setText("");

                    }}}

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });





            }
        });

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    int hora =9;
                    int minuto=0;
                 date = year + "," + month + "," +dayOfMonth+"," + hora+","+ minuto ;

            }
        });



    }


}