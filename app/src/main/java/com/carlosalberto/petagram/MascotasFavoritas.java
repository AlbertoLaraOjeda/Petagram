package com.carlosalberto.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();

        String[] nombres =  parametros.getStringArray("nombres");
        int[] fotos = parametros.getIntArray("fotos");
        int[] likes = parametros.getIntArray("likes");

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(nombres[0], fotos[0]));
        mascotas.add(new Mascota(nombres[1], fotos[1]));
        mascotas.add(new Mascota(nombres[2], fotos[2]));
        mascotas.add(new Mascota(nombres[3], fotos[3]));
        mascotas.add(new Mascota(nombres[4], fotos[4]));

        for (int i=0; i < mascotas.size(); i++){
            mascotas.get(i).setNumeroLikes(likes[i]);
        }


        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}
