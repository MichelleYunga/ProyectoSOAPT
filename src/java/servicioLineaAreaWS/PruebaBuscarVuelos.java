/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioLineaAreaWS;

import ModeloLineaArea.HorarioVuelo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PruebaBuscarVuelos {

    public static void main(String[] args) {
     
        ServicioLineaArea servicio = new ServicioLineaArea();

       
        servicio.RegistroHorario("1", "2023-11-28", "08:00", "10:00");
        servicio.RegistroHorario("2", "2023-11-28", "08:00", "14:00");
        servicio.RegistroHorario("3", "2023-11-29", "09:00", "11:00");

        servicio.registroLineaAerea(1, "Aerolínea 1", "1");
        servicio.registroLineaAerea(2, "Aerolínea 2", "2");
        servicio.registroLineaAerea(3, "Aerolínea 3", "3");

        System.out.println("### Lista de Horarios ###");
        System.out.println(servicio.ListarHorarios());

       
        String fechaBusqueda = "2023-11-28";
        String horaBusqueda = "8:00";

        List<HorarioVuelo> vuelosDisponibles = servicio.buscarVuelosDisponibles(fechaBusqueda, horaBusqueda);

       
        System.out.println("\n### Vuelos Disponibles para " + fechaBusqueda + " a las " + horaBusqueda + " ###");
        if (vuelosDisponibles.isEmpty()) {
            System.out.println("No hay vuelos disponibles.");
        } else {
            for (HorarioVuelo vuelo : vuelosDisponibles) {
                System.out.println("ID de Vuelo: " + vuelo.getIdHorario() +
                                   ", Fecha: " + vuelo.getFecha() +
                                   ", Hora de Llegada: " + vuelo.getHoraLlegada());
            }
        }
    }
}
