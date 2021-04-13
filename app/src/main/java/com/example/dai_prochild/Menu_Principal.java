package com.example.dai_prochild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Menu_Principal extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.menu_principal, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_direitos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_direitos);


            }
        });
        view.findViewById(R.id.btnforum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_forum4);


            }
        });
        view.findViewById(R.id.duvidas_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_chat_Duvidas);


            }
        });
        view.findViewById(R.id.btnapoio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_linhaApoio);


            }
        });
        view.findViewById(R.id.denuncia_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_denuncias);


            }
        });
        view.findViewById(R.id.btn_materiais).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_materiais2);


            }
        });
        view.findViewById(R.id.btnconta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_perfil);


            }
        });
        view.findViewById(R.id.btn_eventos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_eventos);


            }
        });
        view.findViewById(R.id.imageButton6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_Principal.this)
                        .navigate(R.id.action_menu_Principal_to_FirstFragment);


            }
        });

    }


}