package com.carlosalberto.petagram;

/**
 * Created by CarlosAlberto on 11/07/2016.
 */
public class Mascota {

    private String nombre;
    private int numeroLikes;
    private int foto;

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        numeroLikes = 0;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
