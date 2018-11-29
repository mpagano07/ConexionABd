/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionabd.*;

/**
 *
 * @author note
 */
public class Conexion {
    private String url, nombre, clave;
    
    public Conexion(){
        this.url = "jdbc:mysql://localhost/estudiantes";
        this.nombre = "root";
        this.clave = "";
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setClave (String clave){
        this.clave = clave;
    }
    
    public java.sql.Connection conectar(){
        java.sql.Connection conec = null;
    
    try{
        conec=java.sql.DriverManager.getConnection (url,nombre,clave);
    }catch (java.sql.SQLException ex){
        System.out.println(ex);
    }
    return conec;
    }
}
    

    

