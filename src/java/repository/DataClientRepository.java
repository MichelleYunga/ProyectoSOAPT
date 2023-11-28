/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modeloInicioSesion.Cliente;

/**
 *
 * @author Usuario
 */
public class DataClientRepository {

    /*
        - Clase generada para mantener la persistencia de los datos al momento de inciar el servicio
        - Se crea una Lista de clientes que mantiene los datos del registro y que permite buscar
        - Se mantiene mientras el servicio esté activo
    */
    
    private static List<Cliente> dataList = Collections.synchronizedList(new ArrayList<>());

    public static List<Cliente> getDataList() {
        return dataList;
    }

    public static void addClient(Cliente data) {
        dataList.add(data);
    }

    public static DataClientRepository getInstance() {
        return DataRepositoryHolder.INSTANCE;
    }

    public static Cliente getClientByCedula(String cedula) {
        Cliente cliente = new Cliente();

        for (Cliente cli : dataList) {
            if (cli.getCedula().equals(cedula)) {
                cliente = cli;
                break;
            }
        }

        return cliente;
    }

    private static class DataRepositoryHolder {

        private static final DataClientRepository INSTANCE = new DataClientRepository();
    }
}
