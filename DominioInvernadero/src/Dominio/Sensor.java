/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Eliu
 */
public class Sensor implements Serializable {

    private int id;
    private String Nombre;
    private String Compania;
    private float Humedad;
    private float Temperatura;
    private Calendar Fecha;

    public Sensor() {
    }
    
    public Sensor(int id, String Nombre, String Compania) {
        this.id = id;
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Humedad = 0;
        this.Temperatura = 0;
        this.Fecha = new GregorianCalendar();
    }

    public Sensor(int id, String Nombre, String Compania, float Humedad, float Temperatura, Calendar Fecha) {
        this.id = id;
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Humedad = Humedad;
        this.Temperatura = Temperatura;
        this.Fecha = Fecha;
    }
    
    public Sensor(int id, String Nombre, String Compania, float Humedad, float Temperatura) {
        this.id = id;
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Humedad = Humedad;
        this.Temperatura = Temperatura;
        this.Fecha = new GregorianCalendar();
    }

    public Sensor(String Nombre, String Compania) {
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Humedad = 0;
        this.Temperatura = 0;
        this.Fecha = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String Compania) {
        this.Compania = Compania;
    }

    public float getHumedad() {
        return Humedad;
    }

    public void setHumedad(float Humedad) {
        this.Humedad = Humedad;
    }

    public float getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(float Temperatura) {
        this.Temperatura = Temperatura;
    }

    public Calendar getFecha() {
        return Fecha;
    }

    public void setFecha(Calendar Fecha) {
        this.Fecha = Fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Nombre);
        hash = 97 * hash + Objects.hashCode(this.Compania);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sensor other = (Sensor) obj;
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Compania, other.Compania)) {
            return false;
        }
        return true;
    }
    
    public String myTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(Fecha.getTime());
        return date;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + Nombre + " Humedad: " + Humedad + " Temperatura: " + Temperatura + " Fecha "+ myTime() + "\n";
    }

}
