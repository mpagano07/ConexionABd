
package dao;

import conexionabd.*;

public class ConexionABd {

   
    public static void main(String[] args) {
       Conexion conexion = new Conexion();
       
       conexion.setNombre("root");
       conexion.setClave("");
       
       try{
           java.sql.Statement stmt = conexion.conectar().createStatement();
           java.sql.ResultSet consulta = stmt.executeQuery("SELECT * FROM estudiantes");
           
           java.sql.ResultSetMetaData metadata = consulta.getMetaData();
           
           System.out.println(metadata.getColumnName(2) 
                   + " "  + metadata.getColumnName(3));
          
           
           while (consulta.next()){
               System.out.print(consulta.getString("nombre"));
               System.out.println(","  +consulta.getString("apellido"));
               System.out.println(","  +consulta.getString("telefono"));
               System.out.println(","  +consulta.getString("direccion"));
               System.out.println(","  +consulta.getString("mail"));
           }
       }catch (Exception ex ){
       }
    }
    
}
