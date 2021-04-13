package com.example.dai_prochild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class Menu_PrincipalGuardiao extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.menu_principal_guardiao, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        view.findViewById(R.id.btnsugestoes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_sugestoes);


            }
        });
        view.findViewById(R.id.btn_direitos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_direitos);


            }
        });
        view.findViewById(R.id.btn_materiais).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_materiais2);
               // System.out.println(UtilizadorLigado);

            }
        });
        view.findViewById(R.id.btnforum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_forum4);


            }
        });

        view.findViewById(R.id.btnconta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_perfil);


            }
        });

        view.findViewById(R.id.btn_eventos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_eventos);


            }
        });

        view.findViewById(R.id.imageButton7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalGuardiao.this)
                        .navigate(R.id.action_menu_PrincipalGuardiao_to_FirstFragment);


            }
        });
    }


}