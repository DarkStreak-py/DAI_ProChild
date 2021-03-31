package com.example.dai_prochild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Menu_PrincipalInstituicao extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.menu_principal_instutuicao, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btn_direitos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalInstituicao.this)
                        .navigate(R.id.action_menu_PrincipalInstituicao_to_direitosInserir);


            }
        });
        view.findViewById(R.id.btn_materiais).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalInstituicao.this)
                        .navigate(R.id.action_menu_PrincipalInstituicao_to_materiais_Inserir);


            }
        });
        view.findViewById(R.id.btn_eventos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalInstituicao.this)
                        .navigate(R.id.action_menu_PrincipalInstituicao_to_eventos_Inserir);


            }
        });
        view.findViewById(R.id.btnforum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalInstituicao.this)
                        .navigate(R.id.action_menu_PrincipalInstituicao_to_forum4);


            }
        });

        view.findViewById(R.id.btnconta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Menu_PrincipalInstituicao.this)
                        .navigate(R.id.action_menu_PrincipalInstituicao_to_perfil);


            }
        });





    }


}