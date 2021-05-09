/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CRUD<T> {
    private static String CADENA_CONEXION = "jdbc:mysql://localhost/invernadero?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static String USUARIO = "root";
    private static String CONTRASENIA = "1234";

    protected Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
            return conexion;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public abstract void guardar(T entidad);

    public abstract void actualizar(T entidad);

    public abstract void eliminar(int id);

    public abstract ArrayList<T> consultarTodos();

    public abstract T consultarID(int id);
    
    public abstract T consultarPor(String textoBusqueda);
    
    
}