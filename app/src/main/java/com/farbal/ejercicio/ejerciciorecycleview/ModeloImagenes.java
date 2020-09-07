package com.farbal.ejercicio.ejerciciorecycleview;

public class ModeloImagenes {
    private int imagenes;
    private String nombreImagenes;

    public ModeloImagenes(int imagenes, String nombreImagenes) {
        this.imagenes = imagenes;
        this.nombreImagenes = nombreImagenes;
    }

    public int getImagenes() {
        return imagenes;
    }

    public void setImagenes(int imagenes) {
        this.imagenes = imagenes;
    }

    public String getNombreImagenes() {
        return nombreImagenes;
    }

    public void setNombreImagenes(String nombreImagenes) {
        this.nombreImagenes = nombreImagenes;
    }
}
