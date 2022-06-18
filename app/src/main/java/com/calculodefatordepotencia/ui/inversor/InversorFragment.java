package com.calculodefatordepotencia.ui.inversor;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.inversores.InveroresABB;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresDanfos;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresSchneider;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresSiemens;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresVacon;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresWeg;

public class InversorFragment extends Fragment {

    private InversorViewModel mViewModel;
    private ImageView imgWeg;
    private ImageView imgDanfos;
    private ImageView imgAbb;
    private ImageView imgSchineider;
    private ImageView imgSiemens;
    private ImageView imgVacon;


    public static InversorFragment newInstance() {
        return new InversorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inversor_fragment, container, false);

        //recuperando imagem view
        imgWeg = (ImageView)view.findViewById(R.id.imgInvWeg);
        imgAbb = view.findViewById(R.id.imgInvAbb);
        imgDanfos = view.findViewById(R.id.imgInvDamnfos);
        imgSchineider = view.findViewById(R.id.imgInvTelemecanique);
        imgSiemens = view.findViewById(R.id.imgInvSiemens);
        imgVacon = view.findViewById(R.id.imgInvVacon);

        //evento de click weg
        imgWeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresWeg.class);
                startActivity(intent);
            }
        });

        //evento de click ABB
        imgAbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InveroresABB.class);
                startActivity(intent);
            }
        });

        //evento de click Schineider
        imgSchineider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresSchneider.class);
                startActivity(intent);
            }
        });

        //evento de click Siemens
        imgSiemens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresSiemens.class);
                startActivity(intent);
            }
        });

        //evento de click Danfos
        imgDanfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresDanfos.class);
                startActivity(intent);
            }
        });

        //evento de click Vacon
        imgVacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresVacon.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InversorViewModel.class);
        // TODO: Use the ViewModel
    }



}