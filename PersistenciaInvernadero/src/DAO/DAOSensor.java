/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Sensor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOSensor extends CRUD<Sensor> {

    @Override
    public void guardar(Sensor entidad) {
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "INSERT INTO invernadero.sensor (Nombre,Compania,Temperatura,Humedad,Fecha) VALUES (?,?,?,?,?);";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getCompania());
                ps.setFloat(3, entidad.getTemperatura());
                ps.setFloat(4, entidad.getHumedad());
                java.sql.Date date = new Date(entidad.getFecha().getTimeInMillis());
                ps.setDate(5, date);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Sensor entidad) {
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "UPDATE invernadero.sensor SET Nombre = ?, Compania = ?, Temperatura = ?, Humedad = ?, Fecha = ? WHERE (idSensor = ?);";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getCompania());
                ps.setFloat(3, entidad.getTemperatura());
                ps.setFloat(4, entidad.getHumedad());
                java.sql.Date date = new Date(entidad.getFecha().getTimeInMillis());
                ps.setDate(5, date);
                ps.setInt(6, entidad.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "DELETE FROM invernadero.sensor WHERE (idSensor = ?);";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Sensor> consultarTodos() {
        ArrayList<Sensor> lista = new ArrayList<>();
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "SELECT * FROM invernadero.sensor;";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String compania = rs.getString(3);
                    float tem = rs.getFloat(4);
                    float hum = rs.getFloat(5);
                    Calendar fecha = new GregorianCalendar();
                    fecha.setTime(rs.getDate(6));
                    lista.add(new Sensor(id, nombre, compania, tem, hum, fecha));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Sensor consultarID(int id) {
        Sensor sensor = null;
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "SELECT * FROM invernadero.sensor WHERE idSensor = ?;";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                rs.next();

                int idd = rs.getInt(1);
                String nombre = rs.getString(2);
                String compania = rs.getString(3);
                float tem = rs.getFloat(4);
                float hum = rs.getFloat(5);
                Calendar fecha = new GregorianCalendar();
                fecha.setTime(rs.getDate(6));
                
                sensor = new Sensor(idd, nombre, compania, tem, hum, fecha);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return sensor;
    }

    @Override
    public Sensor consultarPor(String textoBusqueda) {
        Sensor sensor = null;
        try {
            try (Connection conexion = this.getConexion()) {
                String sql = "SELECT * FROM invernadero.sensor WHERE Nombre = ?;";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, textoBusqueda);
                ResultSet rs = ps.executeQuery();

                rs.next();

                int idd = rs.getInt(1);
                String nombre = rs.getString(2);
                String compania = rs.getString(3);
                float tem = rs.getFloat(4);
                float hum = rs.getFloat(5);
                Calendar fecha = new GregorianCalendar();
                fecha.setTime(rs.getDate(6));
                sensor = new Sensor(idd, nombre, compania, tem, hum, fecha);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return sensor;
    }

}
