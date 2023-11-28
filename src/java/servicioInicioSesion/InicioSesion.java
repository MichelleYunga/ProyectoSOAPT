/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioInicioSesion;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modeloInicioSesion.Cliente;
import modeloInicioSesion.GenerarUsuarioId;
import repository.DataClientRepository;

/**
 *
 * @author enriq
 */
@WebService(serviceName = "InicioSesion")
public class InicioSesion {

    private GenerarUsuarioId generar = new GenerarUsuarioId();

    //Se llama a la instancia del repositorio 
    private DataClientRepository dataRepository = DataClientRepository.getInstance();

    //Login modificado, se usa un ciclo para buscar a través de los datos persistentes en el repositorio
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        try {
            List<Cliente> clientes = dataRepository.getDataList();

            for (Cliente cli : clientes) {
                if (cli.getUsuario().equals(username) && cli.getContrasena().equals(password)) {
                    return "Credenciales correctas";
                }
            }
            /*
            Cliente cliente = generar.buscarCliente(username, password);
            if (cliente != null) {
                System.out.println("Credenciales correctas");
                return "Credenciales correctas";
            }*/
            System.out.println("Sus credenciales son incorrectas");
            return "sus credenciales son incorrectas";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error durante el inicio sesion", e);
        }
    }

    //METRODO PARA VALIDAR LAS CONTRASEÑAS
    private boolean compararContraseñas(String contraseña1, String contraseña2) {
        return contraseña1.equals(contraseña2);
    }

    /**
     * Web service operation
     */
    
    /*
        -- Registro Modificado
        - Verificar que el usuario exista, que las contraseñas sean correctas
        - Se crea una instancia de usuario, que permite añadirse al repositorio del cual se podrán extraer sus datos
        - Se añade al repositorio y está listo para ser usado
    */
    @WebMethod(operationName = "Registro")
    public String Registro(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "cedula") String cedula, @WebParam(name = "usuaio") String usuaio, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "contrasena1") String contrasena1, @WebParam(name = "pregunta") String pregunta, @WebParam(name = "respuesta") String respuesta) {

        try {
            if (generar.existeUsuario(usuaio)) {
                System.out.println("No se puede registrar, usuario ya existente");
                return "No se puede registrar, usuario ya existente";
            }
            if (!compararContraseñas(contrasena, contrasena1)) {
                System.out.println("Las contraseñas no coinciden");
                return "las contraseñas no coinciden";
            }

            Cliente nuevoCliente = generar.generarClienteConID(nombre, apellido, cedula, usuaio, contrasena, contrasena1, pregunta, respuesta);
            dataRepository.addClient(nuevoCliente);
            System.out.println(nuevoCliente.toString());

            System.out.println("Usuario creado exitosamente. : " + nuevoCliente.getUsuario());
            return "Usuario creado exitosamente";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error durante el registro de usuario", e);

        }
    }


    //Verificar la respuesta - Pregunta
    @WebMethod(operationName = "alterLoginAnswer")
    public boolean alterLogin(@WebParam(name = "response") String response) {
        List<Cliente> clientes = dataRepository.getDataList();
        
        for (Cliente cli : clientes) {
            if (cli.getRespuesta().equalsIgnoreCase(response.trim())) {
                return true;
            }
        }
        
        return false;
    }

    //Guardar la pregunta
    @WebMethod(operationName = "getSecurityQuestion")
    public String getSecurityQuestion(@WebParam(name = "user") String user) {
        List<Cliente> clientes = dataRepository.getDataList();

        for (Cliente cli : clientes) {
            if (cli.getPregunta().equals(user)) {
                return cli.getPregunta();
            }
        }
        return "Don't have a question";
    }
}
