package com.carlosalberto.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnFavorito:
                Intent intent = new Intent(this, MascotasFavoritas.class);
                ArrayList<Mascota> mascotasFavoritas = mascotas;
                do {
                    int index = 0;
                    int likes = 0;
                    likes = mascotasFavoritas.get(0).getNumeroLikes();
                    for (int i=0; i<mascotasFavoritas.size(); i++){

                        if (mascotasFavoritas.get(i).getNumeroLikes() <= likes){
                            likes = mascotasFavoritas.get(i).getNumeroLikes();
                            index = i;
                        }
                    }
                    mascotasFavoritas.remove(mascotasFavoritas.get(index));
                }while (mascotasFavoritas.size() > 5);

                int i = 0;
                int[] fotos = new int[5];
                int[] likes = new int[5];
                String[] nombre = new String[5];

                for (Mascota mascotilla : mascotasFavoritas) {
                    fotos[i] = mascotilla.getFoto();
                    nombre[i] = mascotilla.getNombre();
                    likes[i] = mascotilla.getNumeroLikes();
                    i++;
                }

                intent.putExtra("nombres", nombre);
                intent.putExtra("fotos", fotos);
                intent.putExtra("likes", likes);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Chack", R.drawable.balto));
        mascotas.add(new Mascota("Fionna", R.drawable.fionna));
        mascotas.add(new Mascota("Priscila", R.drawable.pricila));
        mascotas.add(new Mascota("Queta", R.drawable.queta));
        mascotas.add(new Mascota("Frida", R.drawable.frida));
        mascotas.add(new Mascota("Nicky", R.drawable.nicky));
    }
}
