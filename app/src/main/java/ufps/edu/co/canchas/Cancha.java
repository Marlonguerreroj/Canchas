package ufps.edu.co.canchas;

/**
 * Created by marlonguerrero on 24/05/17.
 */

public class Cancha {
    private String nombre, ciudad;
    private float valoracion;

    public Cancha(String nombre, String ciudad, float valoracion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
