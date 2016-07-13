package com.carlosalberto.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CarlosAlberto on 11/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvLikesCV.setText(Integer.toString(mascota.getNumeroLikes()));
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setNumeroLikes(mascota.getNumeroLikes()+1);
                mascotaViewHolder.tvLikesCV.setText(Integer.toString(mascota.getNumeroLikes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton btnLike;
        private ImageView imgHuesoCV;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvNumeroLikesCV);
            imgHuesoCV = (ImageView) itemView.findViewById(R.id.imgHuesoCV);

        }
    }
}
