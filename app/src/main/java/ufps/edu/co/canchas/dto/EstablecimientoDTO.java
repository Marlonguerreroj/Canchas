package ufps.edu.co.canchas.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marlonguerrero on 29/06/17.
 */

public class EstablecimientoDTO {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("ciudad")
    @Expose
    private String ciudad;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("email")
    @Expose
    private String email;

    public EstablecimientoDTO() {
    }

    public EstablecimientoDTO(String nombre, String direccion, String ciudad,
                              String descripcion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
    }

    public EstablecimientoDTO(int id, String nombre, String direccion,
                              String ciudad, String descripcion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
