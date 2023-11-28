/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloInicioSesion;

import ModeloTarjetaCredito.TarjetaCredito;

/**
 *
 * @author enriq
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String usuario;
    private String contrasena;
    private String  valContrasena;
    private String pregunta;
    private String respuesta;

    public Cliente(int idCliente, String nombre, String apellido, String cedula, String usuario, String contrasena, String valContrasena) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.valContrasena = valContrasena;
    }

    public Cliente(int idCliente, String nombre, String apellido, String cedula, String usuario, String contrasena, String valContrasena, String pregunta, String respuesta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Cliente(String cedula) {
        this.cedula = cedula;
    }
    
    
    public Cliente() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getValContrasena() {
        return valContrasena;
    }

    public void setValContrasena(String valContrasena) {
        this.valContrasena = valContrasena;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", usuario=" + usuario + ", contrasena=" + contrasena + ", valContrasena=" + valContrasena + ", pregunta=" + pregunta + ", respuesta=" + respuesta + '}';
    }
    
    

}
