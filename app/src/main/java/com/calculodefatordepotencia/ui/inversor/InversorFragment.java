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
import com.calculodefatordepotencia.activity.activity.inversores.InversoresDanfos;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresWeg;

public class InversorFragment extends Fragment {

    private InversorViewModel mViewModel;
    private ImageView imgWeg;


    public static InversorFragment newInstance() {
        return new InversorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inversor_fragment, container, false);
        imgWeg = (ImageView)view.findViewById(R.id.imgInvWeg);
        imgWeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InversoresWeg.class);
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