/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.EscapeTokenizer;
import entities.Estudiantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.management.remote.JMXConnectorFactory;

/**
 *
 * @author note
 */
public class Consultas extends Conect {
     public boolean editar(String nombre, String apellido, String direccion, String mail, int telefono, int id){
    
     PreparedStatement pst = null;
        try {
            String consulta = "UPDATE `estudiantes` SET Nombre=?,Apellido=?,Telefono=?,Mail=?,Direccion=? WHERE id=?";
            pst = (PreparedStatement) getConnection().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setInt(3, telefono);
            pst.setString(4,mail);
            pst.setString(5, direccion);
            pst.setInt(6, id);
          
            if(pst.executeUpdate() == 1){ //si se afecto a una fila ya que executeupdate devuelve un int
                return true;
            }
        } catch (SQLException exe) {
            System.out.println("ERROR no se inserto"+exe);
        }
        
        return false;
        
    }
    public Estudiantes mostrarPorId(int id){
        PreparedStatement pst = null;
        ResultSet rs = null;
        Estudiantes est = new Estudiantes();
        ArrayList<Estudiantes> dato = new ArrayList();
        try {
            String nombre, apellido, direccion, mail;
            int telefono;
           
            String consulta = "SELECT * FROM estudiantes WHERE id=?";
            pst = (PreparedStatement) getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                est.setApellido(rs.getString("Apellido"));
                est.setDireccion(rs.getString("Direccion"));
                est.setId(rs.getInt("id"));
                est.setMail(rs.getString("Mail"));
                est.setNombre(rs.getString("Nombre"));
                est.setTelefono(rs.getInt("Telefono"));
                dato.add(est);
            }
        } catch (Exception e) {
            
        }
        return est;
    }
    public ArrayList<Estudiantes> MostrarLista(){
        ArrayList<Estudiantes> lista = new ArrayList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String nombre, apellido, direccion, mail;
            int telefono,id;
            String consulta = "SELECT * FROM estudiantes";
            pst = (PreparedStatement) getConnection().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                nombre = rs.getString("Nombre");
                id = rs.getInt("id");
                apellido = rs.getString("Apellido");
                direccion = rs.getString("Direccion");
                mail = rs.getString("Mail");
                telefono = rs.getInt("Telefono");
                Estudiantes e = new Estudiantes(id,nombre, apellido, mail, direccion, telefono);
                //c Estudiantes(String nombre, String apellido, String mail, String direccion, int telefono) {

                lista.add(e); 
            }
         
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return lista; 
    }
    
    public boolean agregarEstudiante (String nombre, String apellido, Integer telefono, String mail, String direccion ){
        PreparedStatement pst = null;
        ResultSet rs = null;
        Estudiantes e = new Estudiantes();
        e.setApellido(apellido);
        e.setDireccion(direccion);
        e.setMail(mail);
        e.setNombre(nombre);
        e.setTelefono(telefono);
        
        try {
            String consulta = "INSERT INTO `estudiantes`(`Nombre`, `Apellido`, `Telefono`, `Mail`, `Direccion`) VALUES (?,?,?,?,?)";
            pst = (PreparedStatement) getConnection().prepareStatement(consulta);
            pst.setString(1, e.getNombre());
            pst.setString(2, e.getApellido());
            pst.setInt(3, e.getTelefono());
            pst.setString(4, e.getMail());
            pst.setString(5, e.getDireccion());
            if(pst.executeUpdate()==1) return true;
        } catch (Exception ex) {
            System.out.println("Error en la inserción"+ex);
        }
        
        return false;
        
    }
    
    public boolean borrarDato(Integer id){
        PreparedStatement pst = null;
        try {
            String consulta = "DELETE FROM `estudiantes` WHERE id=?";
            pst = (PreparedStatement) getConnection().prepareStatement(consulta);
            pst.setInt(1, id);
            if(pst.executeUpdate()==1) return true;
            
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        
        return false;
    }
    public String imprimirArray(ArrayList e){
        String datos = "";
        for (int i = 0; i < e.size(); i++) {
            datos += e.get(i);
        }
        return datos;
        
    }
    // `Id`, `Nombre`, `Apellido`, `Telefono`, `Mail`, `Direccion`
    public static void main(String[] args) {
        Consultas c = new Consultas();
        /*(if(c.agregarEstudiante("juan", "perez", 4343242, "emailllll", "peru 3333")==true){
            System.out.println("Se inserto bien");
        }else{
            System.out.println("Error");
        }*/
        //c.borrarDato(8);
        //System.out.println(c.imprimirArray(c.mostrarPorId(4)));
       // System.out.println("Nuevo" +c.mostrarPorId(4).getApellido());
       c.editar("JUAN", "percha", "peru", "JAJA", 12213, 4);
        
                
    }
    
}
