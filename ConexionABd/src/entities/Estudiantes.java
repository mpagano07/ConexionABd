package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author note
 */

// `Id`, `Nombre`, `Apellido`, `Telefono`, `Mail`, `Direccion`
public class Estudiantes {
    private Integer id;
    private String nombre, apellido,mail,direccion;
    private int telefono;

    public Estudiantes() {
    }

    public Estudiantes(Integer id, String nombre, String apellido, String mail, String direccion, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Estudiantes(String nombre, String apellido, String mail, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", direccion=" + direccion + ", telefono=" + telefono + "\n";
    }
    
    
    
    
}
