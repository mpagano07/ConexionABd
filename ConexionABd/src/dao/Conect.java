/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author note
 */
public class Conect {
    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "estudiantes";
    private String CLASSNAME = "com.mysql.jdbc.Driver"; // Driver de MYSQL
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    Connection con; //libreria de java para conectarse
    public Conect() {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD); // se hace uso del driver para conectarse
            System.out.println("Conexion exitosa..");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR ClassNAME" + e);
        } catch (SQLException e) {
            System.err.println("ERROR SQL" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        Conect con = new Conect();
    }
    
}
