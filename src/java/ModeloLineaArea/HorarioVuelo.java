/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLineaArea;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author enriq
 */
public class HorarioVuelo implements Serializable {
    
     private String idHorario;
    private String fecha;
    private String horaSalida;
    private String horaLlegada;
    
    public HorarioVuelo() {
    }

    public HorarioVuelo(String idHorario, String fecha, String horaSalida, String horaLlegada) {
        this.idHorario = idHorario;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

   

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

 
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
  public boolean coincidenciaFechaHora(String fechaS, String hora) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
    try {
        Date fechaVuelo = dateFormat.parse(this.fecha);
        Date fechaProporcionada = dateFormat.parse(fechaS);
         Date HoraVuelo = dateFormat2.parse(this.horaLlegada);
        Date HoraProporcionada = dateFormat2.parse(hora);

     
        if (!fechaProporcionada.equals(fechaVuelo)&&!HoraProporcionada.equals(HoraVuelo)) {
            return false;
        }

      
        return hora.compareTo(this.horaSalida) >= 0 && hora.compareTo(this.horaLlegada) <= 0;
    } catch (ParseException e) {
        e.printStackTrace();
        return false;
    }
}


    
}