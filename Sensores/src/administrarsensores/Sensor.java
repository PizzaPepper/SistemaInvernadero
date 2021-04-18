/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrarsensores;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Eliu
 */
public class Sensor implements Serializable{
    private String Nombre;
    private String Compania;
    private float Humedad;
    private float Temperatura;

    public Sensor(String Nombre, String Compania) {
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Humedad=0;
        this.Temperatura=0;
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

    @Override
    public String toString() {
        return "Nombre: " + Nombre + " Compania: " + Compania + " Humdedad: "+Humedad+" Temperatura: "+Temperatura;
    }
    
    
    
    
}
