/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrarsensores;

import java.util.Objects;

/**
 *
 * @author Eliu
 */
public class Sensor {
    private String Nombre;
    private String Compania;
    private float Dato;

    public Sensor(String Nombre, String Compania) {
        this.Nombre = Nombre;
        this.Compania = Compania;
        this.Dato = 0;
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

    public float getDato() {
        return Dato;
    }

    public void setDato(float dato) {
        this.Dato = dato;
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
        return "Nombre: " + Nombre + " Compania: " + Compania + " dato=" + Dato;
    }
    
    
    
    
}
