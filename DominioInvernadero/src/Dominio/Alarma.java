/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


public class Alarma {
    private Sensor sensor;
    private Tipo tipo;
    private float desde;
    private float hasta;
    private float dato;

    public Alarma() {
    }

    public Alarma(Sensor sensor, Tipo tipo, float desde, float hasta) {
        this.sensor = sensor;
        this.tipo = tipo;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Sensor getSensor() {
        return sensor;
    }
    
    private float getDato(){
        if(tipo==Tipo.TEMPERATURA)
            dato=sensor.getTemperatura();
        else
            dato=sensor.getHumedad();
            
        return dato;
        
    }
    
    public boolean entraRango(){
        float dato=getDato();
        
        return dato>=desde&&dato<=hasta;
    }
    

   
    
}
