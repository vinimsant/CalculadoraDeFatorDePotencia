package com.calculodefatordepotencia.activity.fragmenty;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftAbb;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftDanfos;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftScheneider;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftSiemens;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftVacon;
import com.calculodefatordepotencia.activity.activity.solftstarter.SolftWeg;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SolftFragmentes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SolftFragmentes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SolftFragmentes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SolftFragmentes.
     */
    // TODO: Rename and change types and number of parameters
    public static SolftFragmentes newInstance() {
        SolftFragmentes fragment = new SolftFragmentes();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ImageView imgWeg;
    private ImageView imgDanfos;
    private ImageView imgAbb;
    private ImageView imgSchineider;
    private ImageView imgSiemens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_solft_fragmentes, container, false);

        imgAbb = view.findViewById(R.id.imgSftAbb);
        imgDanfos = view.findViewById(R.id.imgSftDamnfos);
        imgSchineider = view.findViewById(R.id.imgSftTelemecanique);
        imgSiemens = view.findViewById(R.id.imgSftSiemens);
        imgWeg = view.findViewById(R.id.imgSftWeg);

        imgAbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SolftAbb.class);
                startActivity(intent);
            }
        });

        imgDanfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SolftDanfos.class);
                startActivity(intent);
            }
        });

        imgSchineider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SolftScheneider.class);
                startActivity(intent);
            }
        });

        imgSiemens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SolftSiemens.class);
                startActivity(intent);
            }
        });


        imgWeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SolftWeg.class);
                startActivity(intent);
            }
        });

        return view;
    }
}