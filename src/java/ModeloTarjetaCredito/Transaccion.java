/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTarjetaCredito;

import java.util.Date;

/**
 *
 * @author enriq
 */
public class Transaccion {
    private String descripcion;
    private double monto;
    private Date fecha;

    public Transaccion(String descripcion, double monto, Date fecha) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
