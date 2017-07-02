package ufps.edu.co.canchas.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marlonguerrero on 29/06/17.
 */

public class CanchaDTO {

    @SerializedName("id_cancha")
    @Expose
    private int id;
    @SerializedName("precio_hora")
    @Expose
    private int precioHora;
    @SerializedName("cantidad_personas")
    @Expose
    private int cantidadPersonas;
    @SerializedName("valoracionGeneral")
    @Expose
    private int valoracionGeneral;
    @SerializedName("establecimiento")
    @Expose
    private EstablecimientoDTO establecimiento;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public CanchaDTO() {
        establecimiento = new EstablecimientoDTO();
    }

    public CanchaDTO(int id, int precioHora, int cantidadPersonas,
                     EstablecimientoDTO establecimiento, String descripcion) {
        this.id = id;
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
    }

    public int getValoracionGeneral() {
        return valoracionGeneral;
    }

    public void setValoracionGeneral(int valoracionGeneral) {
        this.valoracionGeneral = valoracionGeneral;
    }

    public CanchaDTO(int precioHora, int cantidadPersonas,
                     EstablecimientoDTO establecimiento, String descripcion) {
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public EstablecimientoDTO getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoDTO establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
